/*
	Compilation
  mpicc -o aquadPartA aquadPartA.c stack.h stack.c

  Discussion
  Uses a queue to keep good order for dispatch

  Worker receives data and if there is a kill tag it quits otherwise
  it computes result. If this is within accecptable limits it returns
  the result using TAG_RESULT otherwise it splits it and sends the
  2 new data sets back using TAG_ADD_TASK.
  
  
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <mpi.h>
#include "stack.h"

#define EPSILON 1e-3
#define F(arg)  cosh(arg)*cosh(arg)*cosh(arg)*cosh(arg)
#define A 0.0
#define B 5.0

#define SLEEPTIME 1

#define TAG_ADD_TASK 100
#define TAG_DO_TASK 101
#define TAG_RESULT 102
#define TAG_KILL 103

int *tasks_per_process;

double farmer(int);
void worker(int);

///// queue stuff

typedef struct queue_node_tag queue_node;
typedef struct queue_tag queue;

struct queue_node_tag {
  int     w_id;
  queue_node *next;
	queue_node *prev;
};

struct queue_tag {
  queue_node     *front;
	queue_node     *end;
};

// creating a new queue
queue * new_queue() {
  queue *n;
  n = (queue *) malloc (sizeof(queue));
  n->front = NULL;
	n->end = NULL;   
  return n;
}

// cleaning up after use
void free_queue(queue *q) {
  free(q);
}

// Push data to queue q, data is a workers id
void push_queue (int w_id, queue *q) {
  queue_node *n;
  n = (queue_node *) malloc (sizeof(queue_node));
  n->w_id  = w_id;

  if (q->front == NULL) {
    n->next = NULL;
		n->prev = NULL;
    q->front  = n;
		q->end    = n;
  } else {
		q->end->next = n;
		n->prev = q->end;
    n->next = NULL;
    q->end = n;
  }
}

// Pop data from queue q
int pop_queue (queue * q) {
  queue_node * n;
  int w_id;
  
  if (q == NULL || q->front == NULL) {
    return NULL;
  }
	
  n = q->front;
	
	if (q->front->next != NULL) {
		q->front = q->front->next;
    q->front->prev = NULL;
	} else {
		q->front = NULL;
	}
	
  w_id = (int) malloc(sizeof(int));
  w_id = n->w_id;

  free (n);
	
  return w_id;
}

// Check for an empty queue
int is_empty_q (queue * q) {
  return (q == NULL || q->front == NULL);
}

// check for number of workers
int workers_available(queue * q) {
	int available = 0;
	
	if (is_empty_q(q)) { return available; }
  
	queue_node *n = q->front;
	while (n != NULL) {
		available++;
		n = n->next;
	} 
	
	return available;
}

// print out the queue
void print_queue(queue * q) {
	if (is_empty_q(q)) { printf("Queue empty"); }
  
	queue_node *n = q->front;
	while (n != NULL) {
		fprintf(stdout, "%d", n->w_id);
		n = n->next;
	} 
	
	fprintf(stdout, "\n");
}



///// main

int main(int argc, char **argv ) {
  
	int i, myid, numprocs;
  double area, a, b;

  MPI_Init(&argc, &argv);
  MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
  MPI_Comm_rank(MPI_COMM_WORLD, &myid);

  if (numprocs < 2) {
    fprintf(stderr, "ERROR: Must have at least 2 processes to run\n");
    MPI_Finalize();
    exit(1);
  }

  if (myid == 0) { // Farmer
    // init counters
    tasks_per_process = (int *) malloc(sizeof(int)*(numprocs));
    for (i=0; i<numprocs; i++) {
      tasks_per_process[i]=0;
    }
  }

  if (myid == 0) { // Farmer
    area = farmer(numprocs);
  } else { //Workers
    worker(myid);
  }

  if (myid == 0) {
    fprintf(stdout, "Area=%lf\n", area);
    fprintf(stdout, "\nTasks Per Process\n");
    for (i=0; i<numprocs; i++) {
      fprintf(stdout, "%d\t", i);
    }
    fprintf(stdout, "\n");
    for (i=0; i<numprocs; i++) {
      fprintf(stdout, "%d\t", tasks_per_process[i]);
    }
    fprintf(stdout, "\n");
    free(tasks_per_process);
  }
  MPI_Finalize();
  return 0;
}

double farmer(int numprocs) {
	
	MPI_Status status;
	int i, flag, source, w_id;
	double result, incoming[5], *derp;
	
	int w_out[numprocs-1];
	
	// Set up stack
	stack *stack = new_stack();
	double data[5] = {A, B, F(A), F(B), (F(A)+F(B)) * (B-A)/2};
	push(data, stack);
	
	// Set up queue
	queue *queue = new_queue();
	for (i=1; i<numprocs; i++) {
	  push_queue(i, queue);
		w_out[i-1] = 0;
	}
	
	while (1) {
		if (!is_empty(stack)) {
			derp = pop(stack);
			w_id = pop_queue(queue);
			w_out[w_id] = 1;
			MPI_Send(derp, 5, MPI_DOUBLE, w_id, TAG_DO_TASK, MPI_COMM_WORLD);
			tasks_per_process[w_id]++;
		}
		
		// peek for messages
		MPI_Iprobe(MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &flag, &status);
			
		// if there is a message
		if (flag) {
			switch(status.MPI_TAG) {
				case TAG_ADD_TASK:
				  
				  // receive data and push onto stack 
				  source = status.MPI_SOURCE;
				  MPI_Recv(&incoming, 5, MPI_DOUBLE, source, TAG_ADD_TASK, MPI_COMM_WORLD, &status);
					push(incoming, stack);
          if (w_out[source]) {
			      push_queue(source, queue);
						w_out[source] = 0;
          }
				  break;
			  case TAG_RESULT:
				  source = status.MPI_SOURCE;
				  MPI_Recv(&incoming, 5, MPI_DOUBLE, source, TAG_RESULT, MPI_COMM_WORLD, &status);
					result += incoming[4];
          if (w_out[source]) {
			      push_queue(source, queue);
						w_out[source] = 0;
          }
					break;
			}
		}
		
		// ready to finish?
	  if (workers_available(queue) == numprocs-1 && is_empty(stack)) { break; }	
	}
	
	// kill and free
  for (i=1; i<numprocs; i++) {
    MPI_Send(&data, 5, MPI_DOUBLE, i, TAG_KILL, MPI_COMM_WORLD);
  }
	free_stack(stack);
	free_queue(queue);
	return result;
}

void worker(int mypid) {
	
  double left, right, fleft, fright, lrarea;
  double mid, fmid, larea, rarea;
  double incoming[5];
  MPI_Status status;
  
  while (1) {
    // receive data
	  MPI_Recv(&incoming, 5, MPI_DOUBLE, 0, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
	  
		// kill worker if kill tag received
		if (status.MPI_TAG == TAG_KILL) { break; }
	  
	  // artificial delay  
	  usleep(SLEEPTIME);
	
	  // get data
	  left = incoming[0], right = incoming[1], fleft = incoming[2], fright = incoming[3], lrarea = incoming[4];   
		
    // calculate new data
	  mid = (left + right) / 2;
    fmid = F(mid);
    larea = (fleft + fmid) * (mid - left) / 2;
    rarea = (fmid + fright) * (right - mid) / 2;
		
    // good enough?
    if(fabs((larea + rarea) - lrarea) > EPSILON) {
	    // send left side
	    incoming[0] = left, incoming[1] = mid, incoming[2] = fleft, incoming[3] = fmid, incoming[4] = larea;
	    MPI_Send(&incoming, 5, MPI_DOUBLE, 0, TAG_ADD_TASK, MPI_COMM_WORLD);
	  
	    // send right side
	    incoming[0] = mid, incoming[1] = right, incoming[2] = fmid, incoming[3] = fright, incoming[4] = rarea;
	    MPI_Send(&incoming, 5, MPI_DOUBLE, 0, TAG_ADD_TASK, MPI_COMM_WORLD);
			
    } else {
	    // send result
      incoming[0] = -1, incoming[1] = -1, incoming[2] = -1, incoming[3] = -1, incoming[4] = larea + rarea;
      MPI_Send(&incoming, 5, MPI_DOUBLE, 0, TAG_RESULT, MPI_COMM_WORLD);			
    }
  }
}

/*
	Compilation
	mpicc -o aquadPartB aquadPartB.c
	
	Discussion
  The farmer splits up the range into equal chunks for the worker
  and passes the resulting data through messages.
  TAG_DO_TASK is used to signify data passing and TAG_RESULT is used
  for result passing.

  The farmer then waits for all the results to come in, it does this
  by checking for potential receives using MPI_IProbe. This is a
  non blocking function which allows the program to continue which
  may be helpful in the case of no messages. If there is a message waiting
  it receives it and updates the results. Once all results are in it returns
  the collated version.

  The workers receive the data and each then call the recursive sequential
  function. Once this has returned the subsections result this is then sent
  back to the farmer along with the call count.
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <mpi.h>

#define EPSILON 1e-3
#define F(arg)  cosh(arg)*cosh(arg)*cosh(arg)*cosh(arg)
#define A 0.0
#define B 5.0

#define TAG_ADD_TASK 100
#define TAG_DO_TASK 101
#define TAG_RESULT 102
#define TAG_KILL 103

int *tasks_per_process;

double farmer(int);
void worker(int);

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
	
  int finished = 0, flag = 0, worker_id = 1;
	double chunk, left, right, result;
	double incoming[2];
	MPI_Status status;
	
	// divide up and send
	for (chunk = A; chunk<B;) {
		left = chunk;
		right = chunk + (B-A)/(numprocs-1);
		
		double data[5] = {left, right, F(left), F(right), (F(left)+F(right)) * (right-left)/2};
    MPI_Send(data, 5, MPI_DOUBLE, worker_id, TAG_DO_TASK, MPI_COMM_WORLD);
		
		worker_id++;
		chunk = right;
	}
	
	// collect results
	while (finished != numprocs-1) {
		
		// peek for messages
		MPI_Iprobe(MPI_ANY_SOURCE, TAG_RESULT, MPI_COMM_WORLD, &flag, &status);
	
		// if there is a message
		if (flag) {
			MPI_Recv(incoming, 2, MPI_DOUBLE, MPI_ANY_SOURCE, TAG_RESULT, MPI_COMM_WORLD, &status);
			result += incoming[0];
		  tasks_per_process[status.MPI_SOURCE] = incoming[1];
			finished++;
	  }
  }
	return result;
}

double quad(int * count, double left, double right, double fleft, double fright, double lrarea) {
  double mid, fmid, larea, rarea;
  
  mid = (left + right) / 2;
  fmid = F(mid);
  larea = (fleft + fmid) * (mid - left) / 2;
  rarea = (fmid + fright) * (right - mid) / 2;

  if(fabs((larea + rarea) - lrarea) > EPSILON) {
    larea = quad(count, left, mid, fleft, fmid, larea);
    rarea = quad(count, mid, right, fmid, fright, rarea);
  }

  *count += 1;
  return (larea + rarea);
}

void worker(int mypid) {
	double left, right, fleft, fright, lrarea;
	double incoming[5], result[2];
	int count = 0;
	MPI_Status status;
	
  // receive data
  MPI_Recv(incoming, 5, MPI_DOUBLE, 0, TAG_DO_TASK, MPI_COMM_WORLD, &status);
	
  // get data
  left = incoming[0], right = incoming[1], fleft = incoming[2], fright = incoming[3], lrarea = incoming[4];
	
	// calculate subsection and send result back
	result[0] = quad(&count, left, right, fleft, fright, lrarea);
	result[1] = count;
	MPI_Send(&result, 2, MPI_DOUBLE, 0, TAG_RESULT, MPI_COMM_WORLD);
}










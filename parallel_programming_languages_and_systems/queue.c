// Simple type for queue of worker ids

#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

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


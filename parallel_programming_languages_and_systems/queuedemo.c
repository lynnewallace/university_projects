// queuedemo.c
// Simple illustration of the use of the provided queue
//
// Compile: gcc -o queuedemo queuedemo.c queue.h queue.c
//
// Run:  ./queuedemo

#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

int main(int argc, char **argv) {

  int i, point;
  int x, data;

  queue *queue = new_queue();

  for (i=0; i<4; i++) {
    point = i;
    push_queue(point, queue);
  }
	fprintf(stdout, "%d \n", workers_available(queue));
  for (i=0; i<5; i++) {
    data = pop_queue(queue);
    x = data;
		fprintf(stdout, "%d \n", x);
  }
	
	fprintf(stdout, "%d \n", workers_available(queue));
	
  for (i=0; i<5; i++) {
    point = i;
    push_queue(point, queue);
  }
	
	fprintf(stdout, "%d \n", workers_available(queue));
	
  for (i=0; i<2; i++) {
    data = pop_queue(queue);
    x = data;
  }
  fprintf(stdout, "%d \n", workers_available(queue));

  return 0;
}

// Simple type for stack of doubles

#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

// creating a new stack
stack * new_stack() {
  stack *n;
  n = (stack *) malloc (sizeof(stack));
  n->top = NULL;
  return n;
}

// cleaning up after use
void free_stack(stack *s) {
  free(s);
}

// Push data to stack s, data has to be an array of 5 doubles
void push (double *data, stack *s)
{
  stack_node *n;
  n = (stack_node *) malloc (sizeof(stack_node));
  n->data[0]  = data[0];
  n->data[1]  = data[1];
  n->data[2]  = data[2];
  n->data[3]  = data[3];
  n->data[4]  = data[4];

  if (s->top == NULL) {
    n->next = NULL;
    s->top  = n;
  } else {
    n->next = s->top;
    s->top = n;
  }
}

// Pop data from stack s
double * pop (stack * s)
{
  stack_node * n;
  double *data;
  
  if (s == NULL || s->top == NULL) {
    return NULL;
  }
  n = s->top;
  s->top = s->top->next;
  data = (double *) malloc(5*(sizeof(double)));
  data[0] = n->data[0];
  data[1] = n->data[1];
  data[2] = n->data[2];
  data[3] = n->data[3];
  data[4] = n->data[4];
  free (n);

  return data;
}

// Check for an empty stack
int is_empty (stack * s) {
  return (s == NULL || s->top == NULL);
}

// Return stack size
int stack_size (stack * s) {
	int size = 0;
	
	if (is_empty(s)) { return size; }
  
	stack_node *n = s->top;
	while (n != NULL) {
		size++;
		n = n->next;
	} 
	
	return size;
}


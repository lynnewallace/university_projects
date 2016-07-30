// stackdemo.c
// Simple illustration of the use of the provided stack
//
// Compile: gcc -o stackdemo stackdemo.c stack.h stack.c
//
// Run:  ./stackdemo

#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main(int argc, char **argv) {

  int i;
  double v, w, x, y, z, *data;
  double points[5];

  stack *stack = new_stack();

  for (i=0; i<10; i++) {
    points[0]=0.1*i;
    points[1]=0.2*i;
    points[2]=0.3*i;
    points[3]=0.4*i;
    points[4]=0.5*i;
    push(points, stack);
  }

  for (i=0; i<10; i++) {
    data = pop(stack);
    v = data[0];
    w = data[1];
    x = data[2];
    y = data[3];
    z = data[4];
    fprintf(stdout, "%2.2f, %2.2f, %2.2f, %2.2f, %2.2f\n", v, w, x, y, z);
  }

  return 0;
}

#ifndef STACK_H_
#define STACK_H_

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct stack_node stack_node;

struct stack_node {
    int data;
    stack_node* next;
};

typedef struct {
    int size;
    stack_node* head;
} stack;

int get_size(stack* s);

int peek(stack* s);

int pop(stack* s);

int push(stack *s, int n);

void print_stack(stack* s);

stack* new_stack(void);

void delete_stack(stack* s);

#endif
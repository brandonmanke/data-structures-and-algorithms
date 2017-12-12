#include "stack.h"

int get_size(stack* s) {
    return s->size;
}

int peek(stack* s) {
    return s->head->data;
}

int pop(stack* s) {
    if (s == NULL || s->head == NULL) {
        return -1;
    }
    int ret = s->head->data;
    stack_node* next = s->head->next;
    s->head->data = -1;
    free(s->head);
    s->head = next;
    s->size--;
    next = NULL; // dereference temp pointer
    return ret;
}

int push(stack *s, int n) {
    if (s == NULL) {
        return -1;
    }
    if (s->head == NULL) {
        s->head = malloc(sizeof(stack_node));
        s->head->data = n;
        s->head->next = NULL;
    }
    stack_node* newHead = malloc(sizeof(stack_node));
    newHead->data = n;
    newHead->next = s->head;
    s->head = newHead;
    s->size++;
    return 1;
}

void print_stack(stack* s) {
    char str[1024] = "";
    stack_node* current = s->head;
    printf("%s: ", "Current Stack");
    while (current->next->next != NULL) {
        sprintf(str, "%d->", current->data);
        printf("%s", str);
        current = current->next;
    }
    sprintf(str, "%d", current->data);
    printf("%s\n", str);
}

stack* new_stack(void) {
    stack* s = malloc(sizeof(stack));
    s->size = 0;
    s->head = NULL;
    return s;
}

void delete_stack(stack* s) {
    if (s == NULL) {
        return;
    }
    if (s->head == NULL) {
        free(s);
    }
    while (get_size(s) > 0) {
        pop(s);
    }
    s->head->data = -1;
    free(s->head);
    free(s);
}
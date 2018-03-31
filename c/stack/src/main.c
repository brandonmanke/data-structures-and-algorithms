#include <stdlib.h>
#include <stdio.h>
#include "stack.h"

int main(void) {
    stack* st = new_stack();
    push(st, 1);
    //printf("Current TOS: %d \n", peek(st));
    push(st, 3);
    //printf("Current TOS: %d \n", peek(st));
    print_stack(st);
    delete_stack(st);
    if (st == 0 || st == NULL) {
        printf("deleted");
    }
    return 0;
}

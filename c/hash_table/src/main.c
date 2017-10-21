#include "hash_table.h"
#include <stdlib.h>

int main(int argc, char **argv) {
    hash_table *ht = ht_new();
    ht_delete_hash_table(ht);
    return 0;
}
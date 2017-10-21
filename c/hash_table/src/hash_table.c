#include <stdlib.h>
#include <string.h>

#include "hash_table.h"

static ht_item* ht_new_item(const char *key, const char *value) {
    ht_item *item = malloc(sizeof(ht_item)); // allocate memory for ht_item
    item->key = strdup(key); // copy to string
    item->value = strdup(value);
    return item;
}

hash_table* ht_new() {
    hash_table *ht = malloc(sizeof(hash_table));
    ht->size = 53;
    ht->count = 0;
    // fill allocated memory with NULL bytes
    ht->items = calloc((size_t)ht->size, sizeof(ht_item*));
    return ht;
}

// free allocated memory for specific item
static void ht_delete_item(ht_item* item) {
    free(item->key);
    free(item->value);
    free(item);
}

void ht_delete_hash_table(hash_table* ht) {
    for (int i = 0; i < ht->size; i++) {
        ht_item *item = ht->items[i];
        if (item != NULL) {
            ht_delete_item(item);
        }
    }
    free(ht->items);
    free(ht);
}
/**
 * Main method
 */
#include <iostream>
#include "linked_list.cpp"

int main() {
    // TODO
    LinkedList<int> *list = new LinkedList<int>();
    list->addToFront(4);
    list->addToEnd(3);
    std::cout << list->toString() << std::endl;
    return 0;
}

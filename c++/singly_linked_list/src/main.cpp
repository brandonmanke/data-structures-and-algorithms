/**
 * main method to test linked list implementation
 * @author Brandon Manke
 */
#include <iostream>
#include "./linked_list.cpp"

int main() {
    LinkedList<int>::LinkedList list(4);
    std::cout << list.value() << std::endl;
    list.setValue(3);
    std::cout << list.value() << std::endl;
    return 0;
}
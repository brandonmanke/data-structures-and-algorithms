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
    std::cout << list->toString() << std::endl; // 4->3
    std::cout << "Average: " << list->average() << std::endl; // 3.5
    std::cout << "Sum: " << list->sum() << std::endl; // 7
    std::cout << "Size: " << list->getSize() << std::endl;
    list->addTo(1, 2);
    std::cout << list->toString() << std::endl; // 4->2->3
    LinkedList<int> *list2 = new LinkedList<int>();
    list2->addToEnd(6); // 6
    list2->addToFront(5); // 5->6
    std::cout << list2->toString() << std::endl; // 5->6
    // Not sure if this should just take list pointers
    // I think this is purely just a design decision
    // to use constant references vs pointers
    list->concat(*list2); 
    std::cout << list->toString() << std::endl; // 4->2->3->5->6
    list2->removeEnd();
    std::cout << list2->toString() << std::endl; // 5
    std::cout << list->toString() << std::endl; // 4->2->3->5
    // list2 is deleted from this call since it is concatted onto list
    delete list;
    list = 0;
    list2 = 0;
    return 0;
}

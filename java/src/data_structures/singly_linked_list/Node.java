package data_structures.singly_linked_list;

/**
 * Node object for linked list, stores data and pointer to next node in list.
 * @author Brandon Manke
 */
class Node<E> {
  E data;
  Node next;

  Node(E data, Node next) {
    this.data = data;
    this.next = next;
  }

  Node(E data) {
    this.data = data;
    this.next = null;
  }
}
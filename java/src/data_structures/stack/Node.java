package data_structures.stack;

/**
 * Simple stack element - based off of linked list node
 * @author Brandon
 */
class Node<E> {
  E data;
  Node<E> next;

  Node(E data, Node<E> next) {
    this.data = data;
    this.next = next;
  }

  Node(E data) {
    this.data = data;
  }
}

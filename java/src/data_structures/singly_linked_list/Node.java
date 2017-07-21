package data_structures.singly_linked_list;

/**
 * Node object for linked list, stores data and pointer to next node in list.
 * @author Brandon Manke
 */
public class Node<E> {
  public E data;
  public Node next;

  public Node(E data, Node next) {
    this.data = data;
    this.next = next;
  }

  public Node(E data) {
    this.data = data;
    this.next = null;
  }
}
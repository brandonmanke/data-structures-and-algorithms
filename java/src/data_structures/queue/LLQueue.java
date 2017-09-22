package data_structures.queue;

/**
 * Linked List implementation of a queue
 * @author Brandon Manke
 */
public class LLQueue<E> {

  private class Node {
    E data;
    Node next;

    public Node(E data) {
      this.data = data;
      next = null;
    }
  }

  private Node front;
  private Node back;
  private int size;

  public LLQueue() {
    front = null;
    back = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public void insert(E data) {
    Node temp = back;
    back = new Node(data);
    back.next = null;
    if (empty())
      front = back;
    else
      temp.next = back;
    size++;
  }

  public E remove(){
    // This exception is temp for now, may eventually make own exception.
    if (empty())
      throw new RuntimeException("Queue is empty.");
    Node temp = front;
    front = front.next;
    size--;
    return temp.data;
  }

  public E front() {
    return front.data;
  }

  public E back() {
    return back.data;
  }

  public boolean empty() {
    return size == 0;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = front;
    while (current.next != null) {
      sb.append(current.data.toString() + "<-");
      current = current.next;
    }
    sb.append(current.data.toString());
    return sb.toString();
  }
}

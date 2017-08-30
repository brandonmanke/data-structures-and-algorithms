package data_structures.stack;

import java.util.EmptyStackException;

/**
 * Linked List implementation of a Stack
 * @author Brandon Manke
 */
public class LLStack<E> {
  private Node<E> head;
  private int size;

  public LLStack() {
    head = null;
    size = 0;
  }

  public int getSize() { return size; }

  /**
   * Peeks at the top element of stack.
   * @return head - The current value/data of the head node.
   */
  public E peek() {
    if (head == null)
      throw new EmptyStackException();

    return head.data;
  }

  /**
   * Pops the top element off the stack.
   * @return removed - The removed value.
   */
  public E pop() {
    if (head == null)
      throw new EmptyStackException();

    E removed = head.data;
    head = head.next;
    size--;
    return removed;
  }

  /**
   * Pushes value on top of stack.
   * @param data - Value to be pushed on top of stack.
   */
  public void push(E data) {
    if (head == null)
      head = new Node(data);

    Node<E> pushed = new Node(data);
    pushed.next = head;
    head = pushed;
    size++;
  }
}

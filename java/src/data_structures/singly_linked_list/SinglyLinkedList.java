package data_structures.singly_linked_list;

import java.util.NoSuchElementException;

/**
 * Singly Linked List implementation
 * @author Brandon Manke
 */
@SuppressWarnings("unchecked")
public class SinglyLinkedList<E> {

    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Gets size of list
     * @return {int} size of linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns value of head node
     * @return {E} value/data of head node
     */
    public E getHead() {
        return head.data;
    }

    /**
     * Returns the value at specified index
     * @param index {int} index location to pull value from
     * @return {E} value of node at specified index
     */
    public E getValue(int index) {
        Node<E> currentNode = head;
        int counter = 0;
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        while (currentNode.next != null) {
            if (counter == index) {
                return currentNode.data;
            }

            if (counter < size - 1) {
                counter++;
            }

            currentNode = currentNode.next;
        }

        throw new NoSuchElementException();
    }

    /**
     * Inserts data at the front of the list
     * @param data {E} data you want to add to beginning of list
     */
    public void insertBefore(E data) {
        Node<E> currentNode = new Node(data);

        if (head == null) {
            head = currentNode;
            size++;
        } else {
            currentNode.next = head;
            head = currentNode;
            size++;
        }
    }

    /**
     * Inserts value at end of list
     * @param data {E} value to be inserted at end of list
     */
    public void insertAfter(E data) {
        Node<E> currentNode = head;

        if (head == null) {
            head = new Node<>(data);
            size++;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = new Node<>(data);
            size++;
        }
    }

    /**
     * Inserts value at specified index
     * @param data {E} value to be inserted at index
     * @param index {int} index in list value is to be inserted
     */
    public void insertAfter(E data, int index) {
        Node<E> currentNode = head;
        int count = 0;

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertBefore(data);
            return;
        }

        if (index == size - 1) {
            insertAfter(data);
            return;
        }

        Node<E> value = new Node<>(data);

        while (currentNode.next != null) {
            if (count == index - 1) {
                value.next = currentNode.next;
                currentNode.next = value;
                size++;
                break;
            }

            if (count <= size - 1) {
                count++;
            }

            currentNode = currentNode.next;
        }
    }

    /**
     * Inserts value before value at specified index
     * @param data {E} value to be inserted at index
     * @param index {int} index in list value is to be inserted before
     */
    public void insertBefore(E data, int index) {
        Node<E> currentNode = head;
        int count = 0;

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertBefore(data);
            return;
        }

        Node<E> value = new Node<>(data);

        while (currentNode.next != null) {
            if (count == index - 2) {
                value.next = currentNode.next;
                currentNode.next = value;
                size++;
                break;
            }

            if (count <= size - 1) {
                count++;
            }

            currentNode = currentNode.next;
        }
    }

    /**
     * Removed head node of list
     * @return {E} data of removed head node
     */
    public E removeHead() {
        Node<E> currentNode = head;
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<E> removedNode = head;
        head = head.next;
        size--;
        return removedNode.data;
    }

    /**
     * Removes value at end of list
     * @return {E} data of removed node
     */
    public E removeEnd() {
        Node<E> currentNode = head;
        if (head == null) {
            throw new NoSuchElementException();
        }

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        Node<E> removedNode = currentNode.next;
        currentNode.next = null;
        size--;
        return removedNode.data;
    }

    /**
     * Removed value at specified index
     * @param index {int} Index of node to be removed
     * @return {E} returns data of removed node
     */
    public E remove(int index) {
        Node<E> currentNode = head;
        int counter = 0;
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            removeHead();
        }

        if (index == size - 1) {
            removeEnd();
        }

        while (currentNode.next != null) {
            if (counter == index - 1) {
                break;
            }
            currentNode = currentNode.next;

            if (counter <= size - 1) {
                counter++;
            }
        }

        Node<E> removedValue = currentNode.next;
        currentNode.next = currentNode.next.next;
        size--;
        return removedValue.data;
    }

    /**
     * Removes first occurrence of value
     * @param value {E} value that is to be removed if found in the list
     * @return {E} removed value if value is found
     * @return {null} null if value is not found in list
     */
    public E removeValue(E value) {
        Node<E> currentNode = head;
        if (head == null) {
            throw new NoSuchElementException(); // list is empty
        }

        if (currentNode.data == value) {
            removeHead();
            return currentNode.data;
        }

        while (currentNode.next.next != null) {
            if (currentNode.next == value) {
                Node<E> temp = currentNode.next;
                currentNode.next = currentNode.next.next;
                size--;
                return temp.data;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    /**
     * Reverses list and returns list of reversed values
     * @return {LinkedList<E>} reversed list
     */
    public SinglyLinkedList<E> reverse() {
        SinglyLinkedList<E> reversed = new SinglyLinkedList<>();
        Node<E> currentNode = head;

        if (head == null) {
            throw new IllegalStateException();
        }

        while (currentNode.next != null) {
            reversed.insertBefore(currentNode.data);
            currentNode = currentNode.next;
        }

        reversed.insertBefore(currentNode.data); // last element
        return reversed;
    }

    @Override
    public String toString() {
        Node<E> currentNode = head;
        String list = "";

        while (currentNode.next != null) {
            list += (currentNode.data.toString() + " --> ");
            currentNode = currentNode.next;
        }

        list += (currentNode.data.toString() + "");
        return list;
    }
}
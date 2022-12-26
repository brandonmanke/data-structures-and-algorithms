public class Stack<E> {
    private int size;
    private Node head;

    private class Node {
        Node next;
        E data;

        public Node() {}

        public Node(E data) {
            this.data = data;
        }
    }

    public Stack() {
        this.head = new Node();
    }

    public E peek() { return this.head.data; }

    public int size() { return this.size; }

    public void push(E data) { 
        Node newHead = new Node(data);
        newHead.next = this.head;
        this.head = newHead;
        this.size++;
    }

    public E pop() {
        E removed = this.head.data;
        this.head = this.head.next;
        this.size--;
        return removed;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node current = head;

        sb.append("[");
        while (current.next != null) { 
            sb.append(current.data);
            sb.append(",");
            current = current.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
 }

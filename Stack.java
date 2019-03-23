public class Stack<E> {
    private int size;
    private Node<E> head;

    private class Node<E> {
        Node<E> next;
        E data;

        public Node() {}

        public Node(E data) {
            this.data = data;
        }
    }

    public Stack() {
        this.head = new Node<E>();
    }

    public E peek() { return this.head.data; }

    public int size() { return this.size; }

    public void push(E data) { 
        Node<E> newHead = new Node<E>(data);
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
        Node<E> current = head;

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

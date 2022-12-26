import java.util.Map;
import java.util.HashMap;

class LRUCache {

    int capacity;
    int size;
    Map<Integer, CacheNode> m = new HashMap<>();
    CacheNode head;
    CacheNode tail;

    class CacheNode {
        int val;
        int key;
        CacheNode next;
        CacheNode prev;

        public CacheNode(int val) { this.val = val; }
        
        public CacheNode(int val, int key) { this.val = val; this.key = key; }

        public CacheNode(int val, int key, CacheNode next, CacheNode prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new CacheNode(-1);
        this.tail = new CacheNode(-1);
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }
    
    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        CacheNode n = m.get(key);
        removeNode(n);
        addNode(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (this.capacity == 0) return;
        if (m.containsKey(key)) { // update & move to head
            CacheNode n = m.get(key);
            n.val = value;
            removeNode(n);
            addNode(n);
        } else { // insert into head
            CacheNode n = new CacheNode(value, key);
            addNode(n);
            m.put(key, n);
            this.size++;
        }
        if (this.size > this.capacity) {
            CacheNode removed = this.tail.next;
            removeNode(removed);
            m.remove(removed.key);
            this.size--;
        }
    }
    
    public void removeNode(CacheNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public void addNode(CacheNode n) {
        n.next = this.head;
        n.prev = this.head.prev;
        this.head.prev.next = n;
        this.head.prev = n;
    }
}

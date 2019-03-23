import java.util.ArrayList;

/**
 * Basic HashMap implementation
 * @param <K>
 * @param <V>
 */
class HashMap<K, V> {
    private ArrayList<Bucket<K, V>> table;
    private int size;
    private int capacity;

    private final int    DEFAULT_CAP     = 10;
    private final double MAX_LOAD_FACTOR = 0.75;
    private final double MIN_LOAD_FACTOR = 0.25;

    private class Bucket<K, V> {
        public K key;
        public V val;
        public Bucket<K, V> next;
        
        public Bucket(K key, V val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }

        public String toString() {
            return "(" + 
                   this.key.toString() + 
                   ", " + 
                   this.val.toString() + ")";
        }
    }

    public HashMap() {
        this.table = new ArrayList<>(DEFAULT_CAP);
        for (int i = 0; i < DEFAULT_CAP; i++) {
            this.table.add(null);
        }
        this.capacity = DEFAULT_CAP;
        this.size = 0;
    }

    public int size() { return this.size; }

    public boolean has(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        int index = hash(key);
        Bucket<K, V> b = table.get(index);
        if (b == null) {
            return null;
        }
        if (b.key.equals(key)) {
            return b.val;
        } else {
            Bucket<K, V> curr = table.get(index);
            while (!curr.key.equals(key) && curr.next != null) {
                curr = curr.next;
            }
            if (curr.key.equals(key)) {
                return curr.val;
            }
        }
        return null;
    }

    public void set(K key, V val) {
        int index = hash(key);
        Bucket<K, V> curr = this.table.get(index);
        if (curr == null) {
            this.table.set(index, new Bucket<>(key, val));
            this.size++;
        } else if (curr.key.equals(key)) {
            curr = new Bucket<>(key, val);
        } else {
            while (curr.next != null) { // Resolve collision
                curr = curr.next;
            }
            curr.next = new Bucket<>(key, val);
            this.size++;
        }

        if (this.loadFactor() >= MAX_LOAD_FACTOR) {
            System.out.println("resize ^ (" + this.loadFactor() + ")");
            System.out.println("old capacity: " + this.capacity);
            resizeTable(true);
            System.out.println("new capacity: " + this.capacity);

        } else if (this.loadFactor() <= MIN_LOAD_FACTOR && this.capacity > DEFAULT_CAP) {
            System.out.println("resize v (" + this.loadFactor() + ")");
            System.out.println("old capacity: " + this.capacity);
            resizeTable(false);
            System.out.println("new capacity: " + this.capacity);
        }
    }

    public V remove(K key) throws Exception {
        int index = hash(key);
        if (this.table.get(index) == null) {
            throw new Exception("Element does not exist");
        }
        Bucket<K, V> curr = this.table.get(index);
        Bucket<K, V> prev = null;
        Bucket<K, V> head = curr; // head of adj list
        while (!curr.key.equals(key) && curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        V removed = null;
        if (curr.key.equals(key)) {
            removed = curr.val;
            if (prev == null) {
                this.table.set(index, curr.next);
            } else {
                prev.next = curr.next; // maybe null doesnt matter
                this.table.set(index, head);
            }
            this.size--;
        } else {
            throw new Exception("Element does not exist");
        }

        if (this.loadFactor() <= MIN_LOAD_FACTOR && this.capacity > DEFAULT_CAP) {
            System.out.println("resize v (" + this.loadFactor() + ")");
            System.out.println("old capacity: " + this.capacity);
            resizeTable(false);
            System.out.println("new capacity: " + this.capacity);
        }

        return removed;
    }

    private int hash(K key) {
        int hk = key.hashCode();
        if (hk < 0) {
            hk *= -1;
        }
        return hk % this.capacity;
    }

    private void resizeTable(boolean expand) {
        if (expand) {
            this.capacity *= 2;
        } else if (!expand && (this.capacity / 2) >= DEFAULT_CAP) {
            this.capacity /= 2;
        } else {
            return;
        }

        ArrayList<Bucket<K, V>> newTable = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            newTable.add(null);
        }
        for (int i = 0; i < this.table.size(); i++) {
            if (this.table.get(i) == null) {
                continue;
            }

            Bucket<K, V> curr = this.table.get(i);
            Bucket<K, V> nextCopy = curr.next;
            curr.next = null;
            insertIntoNewTable(curr, newTable);
            while (nextCopy != null) {
                insertIntoNewTable(nextCopy, newTable);
                nextCopy = nextCopy.next;
            }
        }
        this.table = newTable;
    }

    private void insertIntoNewTable(Bucket<K, V> curr, ArrayList<Bucket<K, V>> newTable) {
        K key = curr.key;
        int newIndex = hash(key);
        if (newTable.get(newIndex) == null) {
            newTable.set(newIndex ,new Bucket<>(curr.key, curr.val));
        } else {
            Bucket<K, V> b = newTable.get(newIndex);
            while (b.next != null) {
                b = b.next;
            }
            b.next = new Bucket<>(curr.key, curr.val);
        }
    }

    private double loadFactor() {
        System.out.println("lf: " + (double) this.size / (double) this.capacity);
        return (double) this.size / (double) this.capacity;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Bucket<K, V> b : this.table) {
            if (b == null) continue;
            sb.append("[");
            sb.append(b.toString());
            Bucket<K, V> curr = b;
            while (curr.next != null) {
                curr = curr.next;
                sb.append("->");
                sb.append(curr.toString());
            }
            sb.append("], ");
        }
        return sb.toString();
    }
}

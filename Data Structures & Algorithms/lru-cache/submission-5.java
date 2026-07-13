/*
- recently used stays before tail and least used after head;
- recently added/get goes before tail
- remove from head.next if size > capacity
- eg. [head] <-> [node3] <-> [node2] <-> [node1] <-> [tail]
*/
class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {this.key = key; this.val = val;}
}

class LRUCache {
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;

        // dummy node pointers
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) remove(map.get(key));
        Node node = new Node(key, value);
        moveToTail(node);
        map.put(key, node);

        // remove after insertion only if size > capacity, edge case if same key is put again
        // this will now trigger cause size stays same
        if (map.size() > capacity) {
            map.remove(head.next.key);
            remove(head.next);
        };
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}

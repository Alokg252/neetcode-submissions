class LRUCache {

    // Define a Node for the Doubly Linked List
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        remove(node);      // Remove from current position
        insertToTail(node); // Move to tail (Most Recently Used)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); // Remove old version
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertToTail(newNode); // Add to tail
        
        if (map.size() > capacity) {
            // Evict Least Recently Used: Node after dummy head
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // Helper: Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert a node right before the dummy tail
    private void insertToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}
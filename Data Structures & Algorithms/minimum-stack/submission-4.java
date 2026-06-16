class MinStack {
    Node head;

    public MinStack() {
        Node head = null;
    }

    public void push(int val) {
        Node node = new Node(val);
        if (head == null) {
            node.min = val;
            node.next = null;
        }
        else {
            node.min = Math.min(head.min, val);
            node.next = head;
        }
        head = node;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }


    static class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val) {this.val = val;}
    }

}

class MinStack {
    private int idx;
    private int[] s;
    private int min;
    private int size;

    public MinStack() {
        this.idx = -1;
        this.min = -1;
        this.size = 500;
        this.s = new int[this.size];
    }

    
    public MinStack(int size) {
        this.idx = -1;
        this.min = -1;
        this.size = size;
        this.s = new int[this.size];
    }
    
    public void push(int val) {
        if (idx+1 == size) throw new IndexOutOfBoundsException("stack is full");
        s[++idx] = val;
        if (min < 0 || val < s[min]) min = idx;
    }
    
    public void pop() {
        checkIfEmpty();
        s[idx--] = 0;
        findMin();
    }
    
    public int top() {
        checkIfEmpty();
        return s[idx];
    }
    
    public int getMin() {
        checkIfEmpty();
        return s[min];
    }

    private void checkIfEmpty() throws IndexOutOfBoundsException {
        if (idx < 0) throw new IndexOutOfBoundsException("stack is empty");
    }

    private void findMin() {
        if (idx < 0) min = -1;
        else if (idx < min && idx >= 0) {
            min = idx;
            for (int i=0; i<=idx; i++)
                if (s[i] < s[min]) min = i;
        }
    }
}

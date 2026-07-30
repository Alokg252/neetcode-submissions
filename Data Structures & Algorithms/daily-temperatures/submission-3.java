class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stack = new Stack<>();
        int l = temps.length;
        int[] arr = new int[l];

        for (int i=l-1; i>=0; i--) {
            if (stack.isEmpty()) {
                arr[i] = 0;
            }
            else if (temps[i] < temps[stack.peek()]) {
                arr[i] = stack.peek() - i;
            }
            else {
                while (stack.size()>0 && temps[stack.peek()]<=temps[i]) 
                   stack.pop();
                if (stack.isEmpty()) arr[i] = 0;
                else arr[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        stack = null;
        System.gc();
        return arr;
    }
}








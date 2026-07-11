class Solution {
    public int[] getNle(int[] arr) {
        int l = arr.length;
        int[] nle = new int[l];
        Stack<Integer> s = new Stack<>();
        s.push(l);
        for (int i=arr.length-1; i>=0; i--) {
            while (s.peek() != l && arr[s.peek()]>=arr[i]) s.pop();
            nle[i] = s.peek();
            s.push(i);
        }
        return nle;
    }

    public int[] getPle(int[] arr) {
        int[] ple = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for (int i=0; i<arr.length; i++) {
            while (s.peek() != -1 && arr[s.peek()]>=arr[i]) s.pop();
            ple[i] = s.peek();
            s.push(i);
        }
        return ple;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nle = getNle(heights);
        int[] ple = getPle(heights);
        int max = 0;
        for (int i=0; i<heights.length; i++) {
            max = Math.max(max, (nle[i] - ple[i] - 1)*heights[i]);
        }

        return max;
    }
}

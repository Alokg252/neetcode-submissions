class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();

        /*
         * i <= heights.length:
         *
         * We run ONE extra iteration.
         * The extra imaginary bar has height 0.
         *
         * Since 0 is smaller than every real bar,
         * it forces all remaining indices out of the stack.
         */
        for (int i = 0; i <= heights.length; i++) {

            int curr = (i == heights.length)
                    ? 0
                    : heights[i];

            while (!s.isEmpty() && heights[s.peek()] >= curr) {

                /*
                 * The current index i is the first smaller
                 * element on the RIGHT of this bar.
                 */
                int val = heights[s.pop()];

                /*
                 * After popping, stack top is the first
                 * smaller element on the LEFT.
                 */
                int left = s.isEmpty() ? -1 : s.peek();

                /*
                 * Valid range:
                 *
                 * left + 1 ........ i - 1
                 *
                 * width = i - left - 1
                 */
                int width = i - left - 1;

                max = Math.max(max, width * val);
            }

            s.push(i);
        }

        return max;
    }
}
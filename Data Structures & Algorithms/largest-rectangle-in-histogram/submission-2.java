
class Solution {

    /*
     * NLE = Next Lesser Element
     *
     * For every index i, find the first index on the RIGHT
     * whose height is STRICTLY SMALLER than arr[i].
     *
     * Why do we need it?
     * arr[i] can extend its rectangle towards the right
     * until we encounter a smaller bar.
     *
     * Example:
     * heights = [2, 1, 5, 6, 2, 3]
     *
     * For height 5 at index 2:
     * next smaller element is 2 at index 4.
     *
     * So NLE[2] = 4.
     *
     * We store INDICES in the stack, not values,
     * because later we need positions to calculate WIDTH.
     *
     * Monotonic stack idea:
     * Remove all elements >= current height.
     *
     * Why?
     * They cannot be the "next smaller" element for current.
     * After removing them, stack top is the nearest smaller element.
     */
    public int[] getNle(int[] arr) {
        int l = arr.length;
        int[] nle = new int[l];

        Stack<Integer> s = new Stack<>();

        /*
         * Sentinel boundary.
         *
         * Index l means:
         * "There is no smaller element on the right."
         *
         * This also makes width calculation easy later.
         */
        s.push(l);

        /*
         * Traverse RIGHT -> LEFT because we are searching
         * for the next smaller element on the RIGHT.
         */
        for (int i = l - 1; i >= 0; i--) {

            /*
             * Remove every height >= current height.
             *
             * We want a STRICTLY SMALLER height.
             *
             * >= is important for duplicate heights.
             * Equal heights should not block the rectangle
             * from expanding further.
             */
            while (
                s.peek() != l &&
                arr[s.peek()] >= arr[i]
            ) {
                s.pop();
            }

            /*
             * Stack top is now:
             *
             * 1. nearest smaller element on the right
             * OR
             * 2. l, meaning no smaller element exists.
             */
            nle[i] = s.peek();

            /*
             * Current index may become the next smaller
             * element for elements to its left.
             */
            s.push(i);
        }

        return nle;
    }


    /*
     * PLE = Previous Lesser Element
     *
     * For every index i, find the first index on the LEFT
     * whose height is STRICTLY SMALLER than arr[i].
     *
     * Why?
     * arr[i] can extend its rectangle towards the left
     * until a smaller bar blocks it.
     *
     * Example:
     * heights = [2, 1, 5, 6, 2, 3]
     *
     * For height 5 at index 2:
     * previous smaller element is 1 at index 1.
     *
     * So PLE[2] = 1.
     */
    public int[] getPle(int[] arr) {
        int[] ple = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        /*
         * Sentinel boundary.
         *
         * -1 means:
         * "There is no smaller element on the left."
         */
        s.push(-1);

        /*
         * Traverse LEFT -> RIGHT because we are searching
         * for the previous smaller element on the LEFT.
         */
        for (int i = 0; i < arr.length; i++) {

            /*
             * Remove all heights >= current height.
             *
             * After popping, stack top is the nearest
             * STRICTLY SMALLER height on the left.
             */
            while (
                s.peek() != -1 &&
                arr[s.peek()] >= arr[i]
            ) {
                s.pop();
            }

            /*
             * Store the nearest smaller index on the left.
             *
             * If none exists, store -1.
             */
            ple[i] = s.peek();

            /*
             * Current index may become the previous smaller
             * element for future bars.
             */
            s.push(i);
        }

        return ple;
    }


    public int largestRectangleArea(int[] heights) {

        /*
         * CORE IDEA:
         *
         * Treat every bar as the SHORTEST bar
         * of some rectangle.
         *
         * If heights[i] is the shortest bar,
         * we can expand:
         *
         * LEFT  -> until previous smaller element
         * RIGHT -> until next smaller element
         *
         *        PLE          i          NLE
         *         ↓           ↓           ↓
         *        smaller   heights[i]   smaller
         *
         * The smaller elements themselves CANNOT be included.
         */
        int[] nle = getNle(heights);
        int[] ple = getPle(heights);

        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            /*
             * Valid rectangle range:
             *
             * ple[i] + 1  ........  nle[i] - 1
             *
             * Width of an inclusive range:
             *
             * right - left + 1
             *
             * = (nle[i] - 1) - (ple[i] + 1) + 1
             *
             * = nle[i] - ple[i] - 1
             *
             * IMPORTANT:
             * PLE and NLE are EXCLUDED because they are smaller.
             */
            int width = nle[i] - ple[i] - 1;

            /*
             * heights[i] is treated as the minimum height
             * of this rectangle.
             */
            int area = width * heights[i];

            max = Math.max(max, area);
        }

        return max;
    }
}

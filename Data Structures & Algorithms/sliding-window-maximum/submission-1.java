// pending
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] maxList = new int[n - k + 1];
        int ri = 0; // Index for our result array

        // Stores indices of elements
        Deque<Integer> deque = new ArrayDeque<>();

        for (int j = 0; j < n; j++) {
            // 1. Remove indices that are out of the current window bounds
            if (!deque.isEmpty() && deque.peekFirst() < j - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove indices of elements smaller than the incoming element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[j]) {
                deque.pollLast();
            }

            // 3. Add current element's index to the back of deque
            deque.offerLast(j);

            // 4. If our window has hit size k, record the maximum
            if (j >= k - 1) {
                maxList[ri++] = nums[deque.peekFirst()];
            }
        }

        return maxList;
    }
}
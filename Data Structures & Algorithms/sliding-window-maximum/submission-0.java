class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) return new int[]{};
        int i=0, j=i+k-1;
        int[] maxList = new int[nums.length - k + 1];

        for(; j < nums.length; i++,j++) {
            int max = Integer.MIN_VALUE;
            for (int x=i; x<=j; x++) if (nums[x] > max) max = nums[x];
            maxList[i] = max;
        }

        return maxList;
    }
}

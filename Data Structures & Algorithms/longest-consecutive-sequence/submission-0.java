class Solution {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if (l <= 1) return l;
        
        Arrays.sort(nums);
        int max = 1;
        int cur = 1;
        for (int i=0; i<l-1; i++) {
            if (nums[i] == nums[i+1]) continue;
            else if (nums[i]+1 == nums[i+1]) cur++;
            else {
                if (cur > max) max = cur;
                cur = 1;
            }
        }
        return cur > max ? cur : max;
    }
}

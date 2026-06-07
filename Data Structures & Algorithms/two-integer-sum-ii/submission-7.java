/*
s -> start pointer, e -> end pointer
increasing s will increase sum
decreasing e will decrease sum 
at a point after adjusting both we'll get the target
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length, s = 0, e = l-1;
        while (s < e) {
            int sum = nums[s] + nums[e];
            if (sum < target) s++;
            else if (sum > target) e--;
            else break;
        }
        return new int[]{s+1, e+1};
    }
}
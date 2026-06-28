class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        if (nums == null || nums.length <= 1) return false;

        Map<Integer, Boolean> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            if (map.getOrDefault(nums[i], false)) return true;
            map.put(nums[i], true);
        }

        return false;
    }
}
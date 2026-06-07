class Solution {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if (l <= 1) return l;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max = 1;
        for (int num : set) {
            if (set.contains(num-1)) continue; 
            int cur = 1;
            while(set.contains(++num)) cur++;
            if (cur > max) max = cur;
        }
        return max;
    }
}

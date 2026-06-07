class Solution {

    /*
    - remove dumplicates by using hash set also increases searching
    - find start of sequence if (num-1) is not in set its the starting
    - count till end of sequence (until n+1 is not in set)
    - keep moving until end and track current max and real max
    */

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

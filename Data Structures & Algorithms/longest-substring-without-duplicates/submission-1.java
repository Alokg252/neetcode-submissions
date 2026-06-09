class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length(), max = 1;

        if (l <= 1) return l;

        Set<Character> set = new HashSet<>();
        for (int i=0; i<l; i++) {
            set.clear();
            set.add(s.charAt(i));
            int j = i+1;
            while (j<l && set.add(s.charAt(j))) j++;
            max = Math.max(max, set.size());
        }

        return max;
    }
}

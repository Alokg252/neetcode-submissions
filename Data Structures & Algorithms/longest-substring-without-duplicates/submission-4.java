class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length(), max = 1, i = 0, j = i+1;
        if (l <= 1) return l;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(i), i);

        while (j < l) {
            char c = s.charAt(j);
            if (map.containsKey(c) && map.get(c) >= i) {
                max = Math.max(max, j-i);
                i = map.get(c) + 1;
            }
            map.put(c, j);
            j++;
        }

        return Math.max(max, j-i);
    }
}

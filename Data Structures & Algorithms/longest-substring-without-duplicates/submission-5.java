class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if (l <= 1) return l;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0; // Left pointer

        // Using a standard loop variable makes 'j' cleaner to track
        for (int j = 0; j < l; j++) {
            char c = s.charAt(j);

            // If we find a duplicate inside our current window, jump 'i' forward
            if (map.containsKey(c) && map.get(c) >= i) {
                i = map.get(c) + 1;
            }

            map.put(c, j);
            // Dynamically calculate the window length on every step
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
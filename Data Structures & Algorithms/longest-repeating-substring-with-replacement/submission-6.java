class Solution {
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        
        char[] chars = s.toCharArray();
        int l = chars.length;
        int[] hash = new int[26];

        int i = 0; // Left pointer
        int maxFreq = 0; // Tracks max frequency dynamically
        int res = 0;

        // Start j at 0 to naturally handle strings of length 1 safely
        for (int j = 0; j < l; j++) {
            // 1. Add the incoming character to our window
            hash[chars[j] - 'A']++;
            
            // 2. Instantly update maxFreq on-the-fly
            maxFreq = Math.max(maxFreq, hash[chars[j] - 'A']);

            // 3. If our window is invalid, shrink it from the left
            while ((j - i + 1) - maxFreq > k) {
                hash[chars[i] - 'A']--;
                i++;
            }

            // 4. Since the while loop guarantees validity, record the max window size
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}

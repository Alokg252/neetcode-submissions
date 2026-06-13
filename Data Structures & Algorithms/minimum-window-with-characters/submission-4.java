// pending 
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] targetHash = new int[128]; // Tracks requirements
        int[] windowHash = new int[128]; // Tracks current window
        
        int uniqueCharactersInT = 0;
        for (char c : t.toCharArray()) {
            if (targetHash[c] == 0) uniqueCharactersInT++;
            targetHash[c]++;
        }

        int i = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        // 'j' acts as our expanding right pointer
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            windowHash[c]++;

            // If we have matched the exact frequency needed for character 'c'
            if (targetHash[c] > 0 && windowHash[c] == targetHash[c]) {
                count++;
            }

            // While the window is valid, try to shrink it from the left
            while (count == uniqueCharactersInT) {
                // Update our minimum window boundaries if this window is smaller
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    startIdx = i;
                }

                char leftChar = s.charAt(i);
                // If losing this character breaks our match requirements, decrement count
                if (targetHash[leftChar] > 0 && windowHash[leftChar] == targetHash[leftChar]) {
                    count--;
                }
                windowHash[leftChar]--;
                i++; // Shrink window
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
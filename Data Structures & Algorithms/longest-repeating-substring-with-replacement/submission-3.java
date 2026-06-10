/*
brute force:
- generating all possible substrings
- tracking max occured char in every substring
- using (chars.length - hash[m]) to get number of replacements 
    that is (length of substring) - (count of occuration of most occurred char)
- substring is compared with max if replacements count <= k
- keep updating max
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int l = s.length(), max = 0;
        for (int i=0; i<l; i++) {
            for (int j=i; j<l; j++) {
                char[] chars = s.substring(i, j+1).toCharArray();
                int[] hash = new int[26];
                int lmax = 0;

                for (int m=0; m<chars.length; m++)
                    hash[chars[m] - 'A']++; 
                
                for (int m=0; m<26; m++)
                    if ((chars.length - hash[m]) <= k)
                        lmax = Math.max(lmax, chars.length);

                max = Math.max(max, lmax);
            }
        }

        return max;
    }
}

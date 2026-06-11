class Solution {
    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();

        int l = chars.length, i=0, j=i+1, max=0, res=0;
        int[] hash = new int[26];

        hash[chars[i] - 'A']++;
        hash[chars[j] - 'A']++;

        while(i<=j && j<l) {

            for (int num : hash) max = Math.max(max, num);
            if (j-i+1 - max <= k)
              res = Math.max(res, j-i+1);

            if ((j-i+1 - max) > k) {
                hash[chars[i++] - 'A']--;
            }
            else if (++j < l) {
              hash[chars[j] - 'A']++;
            }
        }
        return res;
    }
}

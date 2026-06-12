class Solution {

    public boolean checkInclusion(String s1, String s2) {
        char[] key = s1.toCharArray();
        Arrays.sort(key);

        for (int i=0, j=i + key.length; j <= s2.length(); i++, j++) {
            char[] pattern = s2.substring(i,j).toCharArray();
            Arrays.sort(pattern);
            if (Arrays.equals(key, pattern)) return true;
        }

        return false;
    }
}

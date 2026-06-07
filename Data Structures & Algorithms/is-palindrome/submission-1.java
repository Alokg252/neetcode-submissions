class Solution {
    public boolean valid(int n) {
        if ((n>47 && n<58) ||
            (n>64 && n<91) ||
            (n>96 && n<123)) return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int l = s.length();
        if (l <= 1) return true;
        int i = 0, j = l-1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (!valid(chars[i]) && i < j) i++;
            while (!valid(chars[j]) && i < j) j--;
            if ((chars[i++] | 32) != (chars[j--] | 32)) return false;
        }

        return true;
    }}

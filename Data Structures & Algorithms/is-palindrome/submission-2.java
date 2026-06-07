/*
Logic for character lower casing :-
for every lower case alphabet a to z 6th bit is always 1
for every upper case alphabet A to Z 6th bit is always 0
and number 32 has only 6th bit as 1 
so using 32 as mask we can make 
Uppercase to Lower (6th bit as 1) and Lowercase will stay Lower (6th bit as 1)

bits-> 87654321
'A' is 01000001 (65)
'a' is 01100001 (97)
'B' is 01000010 (66)
'b' is 01110010 (98)

65 | 32 = 01000001 OR 00100000 = 01100001 (97)

*/
class Solution {
    public boolean valid(int n) {
        if ((n>47 && n<58) || // 0 to 9
            (n>64 && n<91) || // A to Z
            (n>96 && n<123)) return true; // a to z
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

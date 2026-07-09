class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        int r = 0;
        for (int i=l-1; i>=0; i--) {
            int n = digits[i] + 1;
            r = n/10;
            digits[i] = n%10;

            if (r == 0) return digits;
        }

        int[] newNum = new int[l+1];
        newNum[0] = r;
        for (int i=1; i<= l; i++) newNum[i] = digits[i-1];

        return newNum;
    }
}

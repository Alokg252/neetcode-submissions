class Solution {
    public int trap(int[] height) {
        int l = height.length, total = 0;
        int[] pre = new int[l];
        int[] sup = new int[l];

        for (int i=0, max=0; i<l; i++) {
            max = Math.max(max, height[i]);
            pre[i] = max;
        }

        for (int i=l-1, max=0; i>=0; i--) {
            max = Math.max(max, height[i]);
            sup[i] = max;
        }

        for (int i=0; i<l; i++) {
            total += (Math.min(pre[i], sup[i]) - height[i]);
        }

        return total;
    }
}

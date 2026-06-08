class Solution {
    public int trap(int[] height) {
        int l = height.length, s=0, e=l-1, lmax=0, rmax=0, total=0;
        while (s <= e) { 
            int minOfMaxH = Math.min(lmax, rmax);
            if (minOfMaxH > height[s]) total += minOfMaxH - height[s];
            if (minOfMaxH > height[e]) total += minOfMaxH - height[e];
            if (height[s] > lmax) lmax = height[s];
            if (height[e] > rmax) rmax = height[e];
            if (height[s] > height[e]) e--;
            else s++;
        }
        return total;
    }
}

class Solution {
    public int trap(int[] height) {
        int l = height.length, s=0, e=l-1, lmax=0, rmax=0, total=0;
        while (s <= e) { 
            
            // find min of max found heights till now
            int minOfMaxH = Math.min(lmax, rmax);

            // if current height is less then min of max height they can trap water
            if (minOfMaxH > height[s]) total += minOfMaxH - height[s];
            if (minOfMaxH > height[e]) total += minOfMaxH - height[e];

            // update max heights
            if (height[s] > lmax) lmax = height[s];
            if (height[e] > rmax) rmax = height[e];
            
            // move pointer by checking smaller height 
            if (height[s] > height[e]) e--;
            else s++;
        }
        // return total trapped water
        return total;
    }
}

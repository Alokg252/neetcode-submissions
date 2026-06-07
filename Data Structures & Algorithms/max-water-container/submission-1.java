class Solution {
    public int area(int h1, int h2, int dis) {
        return h1 > h2 ? h2 * dis : h1 * dis;
    }

    public int maxArea(int[] heights) {
        int l=heights.length, s=0, e=l-1;
        int cur = 0, max = 0;
        while (s < e) {

            cur = area(heights[s], heights[e], e - s);
            if (cur > max) max = cur;
            if (heights[s] > heights[e]) e--;
            else s++;

        }
        return max;
    }
}

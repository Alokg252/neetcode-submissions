class Solution {
    public int findMin(int[] nums) {
        int l = nums.length, s = 0, e = l-1, end = nums[e], min = nums[0];
        if (l == 1 || nums[s] < nums[e]) return min;

        while (s <= e) {
            int mid = s + (e-s)/2;
            int element = nums[mid];
            min = Math.min(element, min);

            // if element > end means array is rotated and mid is behind min value
            // eg. [5,6,7,2,3,4]
            if (element > end) s = mid+1;
            else if (element < end) e = mid-1; 
            else return end;
        } 

        return min;
    }
}

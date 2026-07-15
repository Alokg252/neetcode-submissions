class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;

        int s = 0;
        int e = l1;

        while (s <= e) {

            /*
             * i and j are PARTITION POSITIONS.
             *
             * i = number of nums1 elements on left
             * j = number of nums2 elements on left
             */
            int i = s + (e - s) / 2;
            int j = (total + 1) / 2 - i;

            /*
             * Boundary values around both partitions.
             *
             * nums1: ... left1 | right1 ...
             * nums2: ... left2 | right2 ...
             */
            int left1 = i == 0
                    ? Integer.MIN_VALUE
                    : nums1[i - 1];

            int right1 = i == l1
                    ? Integer.MAX_VALUE
                    : nums1[i];

            int left2 = j == 0
                    ? Integer.MIN_VALUE
                    : nums2[j - 1];

            int right2 = j == l2
                    ? Integer.MAX_VALUE
                    : nums2[j];

            /*
             * Correct partition:
             *
             * everything on LEFT <= everything on RIGHT
             */
            if (left1 <= right2 && left2 <= right1) {

                // Odd total length:
                // median is largest element on LEFT.
                if ((total & 1) == 1) {
                    return Math.max(left1, left2);
                }

                // Even total length:
                // average of:
                // largest LEFT + smallest RIGHT.
                return (
                    (double) Math.max(left1, left2)
                    + Math.min(right1, right2)
                ) / 2;
            }

            /*
             * nums1 contributed too many elements
             * to the LEFT partition.
             */
            else if (left1 > right2) {
                e = i - 1;
            }

            /*
             * nums1 contributed too few elements
             * to the LEFT partition.
             */
            else {
                s = i + 1;
            }
        }

        return 0;
    }
}
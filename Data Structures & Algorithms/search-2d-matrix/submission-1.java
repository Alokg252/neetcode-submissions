class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length;
        int c = matrix[0].length;

        int s = 0;
        int e = ( r * c) - 1;

        while (s <= e) {
            int m = s + (e-s)/2;
            int row = m / c;
            int col = m % c;
            int element = matrix[row][col];

            if (element < target) s = m + 1;
            else if (element > target) e = m - 1;
            else return true;
        }

        return false;
    }
}

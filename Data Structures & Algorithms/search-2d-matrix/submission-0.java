class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
                        
        int low = 0;
        int high = (rows * cols) - 1; // Virtual 1D bounds

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Map 1D index back to 2D coordinates
            int row = mid / cols;
            int col = mid % cols;
            int midElement = matrix[row][col];

            if (midElement == target) {
                return true; 
            } else if (midElement < target) {
                low = mid + 1; // Search right half
            } else {
               high = mid - 1; // Search left half
            }
        }

        return false;

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length; // rows = 3, cols = 4
        int left = 0, right = (rows-1) * cols + (cols-1); // left = 0, right = 3

        while (left <= right) { 
            int mid = left + (right-left)/2; // mid = 1
            int x = mid / cols; // x = 1
            int y = mid % cols; // y = 0
            int num = matrix[x][y]; // num = 5

            if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
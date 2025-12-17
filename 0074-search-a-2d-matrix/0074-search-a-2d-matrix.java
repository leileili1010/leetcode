class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length; // m = 3, n = 4
        int left = 0, right = m*n-1; // left = 0, right = 11

        while (left <= right) { // 0 <= 11
            int mid = left + (right-left)/2; // mid = 1
            int x = mid / n; // x = 0
            int y = mid % n; // y = 1
            int num = matrix[x][y]; // num = 1

            if (num < target) {
                left = mid + 1; // left = 1
            } else if (num > target) {
                right = mid - 1; // right = 1
            } else {
                return true;
            }
        }
        return false;
    }
}
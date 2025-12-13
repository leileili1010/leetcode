class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 翻转
        for (int[] row: matrix) {
            for (int j = 0; j < n/2; j++) {
                int temp = row[j];
                row[j] = row[n-1-j];
                row[n-1-j] = temp;
            }
        }
    }
}
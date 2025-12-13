class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // 转置：对角线上方
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

            // 翻转
            int[] row = matrix[i];
            for (int j = 0; j < n/2; j++) {
                int temp = row[j];
                row[j] = row[n-1-j];
                row[n-1-j] = temp;
            }
            
        }

    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m-1;

        while (res.size() < m * n) {
            for (int j = left; j <= right && res.size() < m * n; j++) {
                res.add(matrix[top][j]);
            }

            for (int i = top+1; i <= bottom && res.size() < m * n; i++) {
                res.add(matrix[i][right]);
            }

            for (int j = right-1; j >= left && res.size() < m * n; j--) {
                res.add(matrix[bottom][j]);
            }

            for (int i = bottom-1; i >= top+1 && res.size() < m * n; i--) {
                res.add(matrix[i][left]);
            }

            top++; bottom--; left++; right--;
        }

        return res;
    }
}
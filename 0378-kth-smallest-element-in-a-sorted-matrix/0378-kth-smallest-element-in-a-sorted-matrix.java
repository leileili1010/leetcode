class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityBlockingQueue<Integer> que = new PriorityBlockingQueue<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                que.offer(matrix[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = que.poll();
        }

        return res;
    }
}
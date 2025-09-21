class Solution {
    private int[] prefixSum;
    private int sum;

    public Solution(int[] w) {
        prefixSum = new int[w.length+1];
        for (int i = 0; i < w.length; i++) {
            prefixSum[i+1] = prefixSum[i] + w[i];
        }
        sum = prefixSum[prefixSum.length-1];
    }
    
    public int pickIndex() {
        double num = (Math.random() * sum);

        int res = 0, left = 0, right = prefixSum.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (prefixSum[mid] < num) {
                left = mid+1;
            } else {
                right = mid-1;
                res = mid;
            }
        }
        return res-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
class Solution {
    private int[] prefixSum;
    private int total;

    public Solution(int[] w) {
        this.prefixSum = new int[w.length+1];

        for (int i = 0; i < w.length; i++) {
            this.prefixSum[i+1] = prefixSum[i] + w[i];
           
        }
        total = prefixSum[prefixSum.length-1];
    }
    
    public int pickIndex() {
        double target = this.total * Math.random();
        for (int i = 0; i < this.prefixSum.length; i++) {
            if (this.prefixSum[i] > target ) {
                return i-1;
            }
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
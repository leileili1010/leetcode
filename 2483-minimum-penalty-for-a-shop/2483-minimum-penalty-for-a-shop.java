class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixSum = new int[n+1];

        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + (customers.charAt(i) == 'Y'? 1: -1);
            if (prefixSum[i+1] > max) {
                max = prefixSum[i+1];
                res = i+1;
            }
        }
        return res;
    }
}
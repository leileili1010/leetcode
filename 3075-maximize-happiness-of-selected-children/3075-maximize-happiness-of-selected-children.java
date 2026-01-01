class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int j = 0;

        for (int i = happiness.length - 1; i >= 0 && j < k; i--) {
            int gain = happiness[i] - j;
            if (gain <= 0) break;
            ans += gain;
            j++;
        }
        return ans;
    }
}
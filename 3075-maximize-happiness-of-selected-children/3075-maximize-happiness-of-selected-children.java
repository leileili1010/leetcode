class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        int rounds = 0;
        int n = happiness.length;
        Arrays.sort(happiness);

        int i = n-1;
        while (k > 0 && i >= 0) {
            int happy = happiness[i--] - rounds;
            res += happy > 0? happy: 0;
            rounds++;
            k--;
        }
        return res;
    }
}
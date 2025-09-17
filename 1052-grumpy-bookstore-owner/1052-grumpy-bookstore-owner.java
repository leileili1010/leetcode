class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int N = grumpy.length;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (i < minutes) {
                sum += customers[i];
            } else {
                sum += (1-grumpy[i]) * customers[i];
            }
        }

        int left = 0, res = sum;
        for (int i = minutes; i < N; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[left] == 1) {
                sum -= customers[left];
            }
            res = Math.max(res, sum);
            left++;
        }
        return res;
    }
}
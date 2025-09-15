class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (i < minutes) {
                sum += customers[i];
            } else {
                sum += (1-grumpy[i]) * customers[i];
            }
        }

        int res = sum, left = 0;
        for (int i = minutes; i < n; i++ ) {
            if (grumpy[i] == 1) sum += customers[i];
            if (grumpy[left] == 1) sum -= customers[left];
            left++;
            res = Math.max(res, sum);
        }
        
        return res;
    }
}
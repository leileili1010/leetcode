class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length; // 4
        int sum = 0;

        // 初始化
        for (int i = 0; i < n; i++) { 
            if (i < minutes) { 
                sum += customers[i];
            } else {
                sum += (1-grumpy[i]) * customers[i]; 
            }
        } // sum = 8

        int left = 0, res = sum; // res = 8
        for (int i = minutes; i < n; i++) { // i = 3
            if (grumpy[i] == 1) sum += customers[i]; // sum = 23
            if (grumpy[left] == 1) sum -= customers[left]; // left = 2
            res = Math.max(res, sum); // res = 14
            left++;
        }

        return res;
    }
}
class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        // n = 3 1, 2, 3
        // sum = target
        // n = 4, target = 2
        // [1, 2, 3, 4]
        // [-4, 1,  2, 3]
        // maxSum = 10, -10
        // posS + negS = maxSum = 10
        // posS - negS = target
        // 2 * negS = maxSum - target
        
        // corner cases
        // 1) Math.abs(target) > maxSum,
        // 2)  (maxSum - target) % 2 == 0


        long maxSum = (long)n * (n + 1) / 2;
        if (Math.abs(target) > maxSum || (maxSum - target) % 2 != 0) return new int[]{};

        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        long negSum =  (maxSum - target) / 2;

        // x ~ [1, n]
        for (int x = n; x > 0; x--) {
            if (negSum >= x) {
                res[left++] = -x;
                negSum -= x;
            } else {
                res[right--] = x;
            }
        }
        return res;
    }
}
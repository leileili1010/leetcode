class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        int[] diff = new int[length]; // 差分数组，初始全 0

        // 1. 处理所有区间更新：O(k)
        for (int[] update : updates) {
            int value = update[2]; 
            int start = update[0];
            int end = update[1];
            
            res[start] += value;
            if (end < length-1) res[end+1] -= value;
        }

        // 2. 前缀和还原最终数组：O(n)
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int size = n - 1;
        int[] checkList = new int[size];
        for (int i = 0; i < size; i++) {
            checkList[i] = i;
        }

        int ans = 0;
        next:
        for (int j = 0; j < m; j++) {
            for (int t = 0; t < size; t++) {
                int i = checkList[t];
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    // j 列不是升序，必须删
                    ans++;
                    continue next;
                }
            }
            // j 列是升序，不删更好
            int newSize = 0;
            for (int t = 0; t < size; t++) {
                int i = checkList[t];
                if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                    // 相邻字母相等，下一列 i 和 i+1 需要继续比大小
                    checkList[newSize++] = i; // 原地覆盖
                }
            }
            size = newSize;
        }
        return ans;
    }
}


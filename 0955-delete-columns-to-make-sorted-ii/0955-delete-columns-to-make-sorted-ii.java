class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        String[] a = new String[n]; // 最终得到的字符串数组
        Arrays.fill(a, "");

        int ans = 0;
        next:
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 1; i++) {
                if ((a[i] + strs[i].charAt(j)).compareTo(a[i + 1] + strs[i + 1].charAt(j)) > 0) {
                    // j 列不是升序，必须删
                    ans++;
                    continue next;
                }
            }
            // j 列是升序，不删更好
            for (int i = 0; i < n; i++) {
                a[i] += strs[i].charAt(j);
            }
        }
        return ans;
    }
}


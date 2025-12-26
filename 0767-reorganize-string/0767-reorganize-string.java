class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        int m = 0;
        char mch = 0;
        for (char ch : s.toCharArray()) {
            if (++count[ch - 'a'] > m) {
                m = count[ch - 'a'];
                mch = ch;
            }
        }
        if (m > n - m + 1) {
            return "";
        }

        char[] ans = new char[n];
        int i = 0;
        for (; m-- > 0; i += 2) {
            ans[i] = mch; // 先填出现次数最多的字母
        }
        count[mch - 'a'] = 0;

        // 再填其它字母
        for (int j = 0; j < 26; j++) {
            int cnt = count[j];
            while (cnt-- > 0) {
                if (i >= n) {
                    i = 1; // 填完偶数填奇数
                }
                ans[i] = (char) ('a' + j);
                i += 2;
            }
        }
        return new String(ans);
    }
}

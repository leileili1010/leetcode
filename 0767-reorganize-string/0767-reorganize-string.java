class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        int max = 0, maxChar = 0;

        // 统计频率
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]++;
            if (count[idx] > max) {
                max = count[idx];
                maxChar = idx;
            }
        }

        // 如果最大频率超过 limit → 无法重排
        if (max > (n + 1) / 2) return "";

        char[] res = new char[n];
        int index = 0;

        // 先放置出现次数最多的字符（放在偶数 index）
        while (count[maxChar] > 0) {
            res[index] = (char)(maxChar + 'a');
            index += 2;
            count[maxChar]--;
        }

        // 放置剩余字符
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= n) index = 1; // 偶数位放完 → 换到奇数位
                res[index] = (char)(i + 'a');
                index += 2;
                count[i]--;
            }
        }

        return new String(res);
    }
}

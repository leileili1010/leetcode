class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] count = new int[26];
        int[] window = new int[26];
        int kinds = 0; // p中不同字母的种类数

        for (char c : p.toCharArray()) {
            if (count[c - 'a'] == 0) kinds++;
            count[c - 'a']++;
        }

        int left = 0, right = 0, match = 0;
        while (right < s.length()) {
            int idx = s.charAt(right) - 'a';
            window[idx]++;
            if (window[idx] == count[idx]) match++;
            if (window[idx] == count[idx] + 1) match--; // 多了

            // 窗口收缩到长度等于p
            while (right - left + 1 > p.length()) {
                int li = s.charAt(left) - 'a';
                if (window[li] == count[li]) match--;
                if (window[li] == count[li] + 1) match++;
                window[li]--;
                left++;
            }

            if (right - left + 1 == p.length() && match == kinds) {
                res.add(left);
            }

            right++;
        }
        return res;
    }
}

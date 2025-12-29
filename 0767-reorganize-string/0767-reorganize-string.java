class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null; // 上一个字符（暂存，避免相邻）

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            sb.append((char)(cur[0] + 'a'));
            cur[1]--;

            // 上一个字符可以重新入堆
            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            // 当前字符成为新的 prev
            prev = cur;
        }

        // 如果最后还有剩余，说明无解
        return sb.length() == s.length() ? sb.toString() : "";
    }
}

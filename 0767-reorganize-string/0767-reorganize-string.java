class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.offer(new int[]{i, freq[i]});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            sb.append((char)(cur[0] + 'a'));
            cur[1]--;

            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            prev = cur;
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}

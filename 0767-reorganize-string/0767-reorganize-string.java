class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) freq[c-'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[1] - a[1])); // <index, freq>
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        if (maxFreq > (s.length()+1)/2) return "";

        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            sb.append((char)(cur[0] + 'a'));
            cur[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }
            prev = cur;
        }
        return sb.toString();
    }
}
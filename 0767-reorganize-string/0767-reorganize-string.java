class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) freq[c-'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        for (int i= 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] {i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int cycle = 2;
            List<int[]> store = new ArrayList<>();

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int[] cur = maxHeap.poll();
                char c = (char)(cur[0] + 'a');
                if (sb.length() > 0 && sb.charAt(sb.length()-1) == c) return "";
                sb.append(c);
                if (--cur[1] > 0) store.add(cur);
                cycle--;
            }

            if (store.size() > 0) maxHeap.addAll(store);
        }

        return sb.toString();
    }
}


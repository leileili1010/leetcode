class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c: s.toCharArray()) {
            freq[c]++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> freq[b] - freq[a]); 

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                maxHeap.offer((char)i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();

            for (int i = 0; i < freq[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
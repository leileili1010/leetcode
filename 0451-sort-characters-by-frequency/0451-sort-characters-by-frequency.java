class Solution {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            int freq = count[i];
            if (freq > 0) {
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int f = buckets.length - 1; f > 0; f--) {
            if (buckets[f] != null) {
                for (char c : buckets[f]) {
                    for (int i = 0; i < f; i++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}

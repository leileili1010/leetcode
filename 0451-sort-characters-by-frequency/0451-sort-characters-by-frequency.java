class Solution {
    public String frequencySort(String s) {
        // 统计freq
        int[] freq = new int[128];
        for (char c: s.toCharArray()) freq[c]++;

        // bucket sort
        List<Character>[] buckets = new List[s.length()+1];
        for (int i = 0; i < freq.length; i++) {
            int count = freq[i];
            if (count > 0) {
                if (buckets[count] == null) {
                    buckets[count] = new ArrayList<>();
                }
                buckets[count].add((char)i);
            }
        }

        // sb
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length-1; i > 0; i--) {
            List<Character> bucket = buckets[i];
            if (bucket == null) continue;

            for (char c: bucket) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
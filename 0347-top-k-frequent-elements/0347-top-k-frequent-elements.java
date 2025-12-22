class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count freq using hashmap
        // construc bucket, idx is the freq
        // update res

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int max = Collections.max(map.values());

        List<Integer>[] buckets = new List[max+1];
        for (int key: map.keySet()) {
            int idx = map.get(key);
            if (buckets[idx] == null) buckets[idx] = new ArrayList<>();
            buckets[idx].add(key);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = max; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (int num: buckets[i]) {
                res[idx++] = num; 
            }
        }
        return res;
    }
}
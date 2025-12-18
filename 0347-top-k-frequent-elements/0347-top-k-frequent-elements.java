class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count freq of each letter
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max = Collections.max(map.values());

        // build bucket
        List<Integer>[] buckets = new List[max+1];
        for (int key: map.keySet()) {
            int idx = map.get(key);
            if (buckets[idx] == null) buckets[idx] = new ArrayList<>();
            buckets[idx].add(key);
        }

        // update res   
        int[] res = new int[k];
        int idx = 0;
        for (int i = max; i >= 0 && idx < k; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket == null) continue;
            
            for (int num: bucket) {
                res[idx++] = num;
            }
        }
        return res;
    }
}
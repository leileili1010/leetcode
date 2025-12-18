class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1.count each letter 
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            max = Math.max(max, map.get(num));
        }

        // 2.build buckets array
        List<Integer>[] buckets = new List[max+1]; 
        for (int key: map.keySet()) {
            int idx = map.get(key);
            if (buckets[idx] == null) buckets[idx] = new ArrayList<>();
            buckets[idx].add(key);
        }

        // 3. update res
        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length-1; i >= 0 && idx < k; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket == null) continue;
            for (int num: bucket) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }
        return res;
    }
}
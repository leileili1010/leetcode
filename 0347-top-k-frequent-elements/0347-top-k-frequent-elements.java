class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // contruct frequency map
        // bucket sort
            // An arrya of length of N+1
            // loop through map to get frequncy, 
            // arr[freq] = new ArrayList<>(), and then add nums
        // loop through arr from backwards, select k numbers
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        int n = nums.length;
        List<Integer>[] freq = new List[n+1];
        for (int key: map.keySet()) {
            int idx = map.get(key);
            if (freq[idx] == null) freq[idx] = new ArrayList<>();
            freq[idx].add(key);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = n; i >= 0 && idx < k; i--) {
            if (freq[i] == null) continue;
            for (int num: freq[i]) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }

        return res;
    }
}
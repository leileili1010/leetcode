class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // bucket[i] = list of numbers that appear i times
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        }

        // collect results from highest frequency to lowest
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 1 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        // convert to int[]
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = res.get(i);
        return ans;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 单调栈， 单调递减，<num>

        // 1. save num1 index and num in HashMap
        Map<Integer, Integer> map = new HashMap<>(); // <num, index>
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i);
        } 

        // 2. 
        int[] res = new int[n];
        Arrays.fill(res, -1);

        // 3. 
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num: nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                int top = stack.pop();
                res[map.get(top)] = num;
            }
            if (map.containsKey(num)) stack.push(num);
        }
        return res;
    }
}
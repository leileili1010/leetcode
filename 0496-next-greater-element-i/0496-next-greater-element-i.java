class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        // nums1 = [2,4], nums2 = [1,2,3,4]
        // map: (2: 0) (4: 1)
        // stack: [4 ] 
        // res [3, -1] 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i);
        }

        Deque<Integer> stack = new ArrayDeque<>(); // descending order
        for (int num: nums2) { // num = 4
            while (!stack.isEmpty() && num > stack.peek()) {
                int top = stack.pop(); // 3
                if (map.containsKey(top)) {
                    res[map.get(top)] = num;
                }
            }
            stack.push(num);
        }
        return res;
    }
}
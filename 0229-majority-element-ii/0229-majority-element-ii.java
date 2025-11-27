class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length; // n = 2
        Arrays.sort(nums); // [1,2]
        int slow = 0, fast = 0;
        List<Integer> res = new ArrayList<>();

        while (fast < n) { // 0 < 2
            int count = 0; 

            while (fast < n && nums[fast] == nums[slow]) { // fast 1 > slow 0, 
                fast++;
            }
            count = fast - slow; // count  = 1
            if (count > n/3) res.add(nums[slow]);
            slow = fast; // slow = 1
        }

        return res;
    }
}
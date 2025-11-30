class Solution {
    public int countElements(int[] nums, int k) {
        int count = 0, n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int j = findLargerNum(i+1, nums[i], nums);
            
            if (n-j >= k) count++;   
        }
        return count;
    }

    private int findLargerNum(int left, int target, int[] nums) {
        int right = nums.length - 1;
        int res = nums.length;   // 或用 -1，看你习惯

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                res = mid;       // mid 是一个可能答案
                right = mid - 1; // 继续找更左的
            } else {
                left = mid + 1;
            }
        }
        return res;  // 记录到的第一个 > target 的位置
    }
}
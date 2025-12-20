class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // 1. find the intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 2. find the duplicate
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast]; 
        }
        return slow;
    }
}
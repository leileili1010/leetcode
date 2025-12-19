class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0; //一定不在环上，适合作为起点

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
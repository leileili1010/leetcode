class Solution {
    public int singleNonDuplicate(int[] nums) {
       int left = 0, right = nums.length - 1;
while (left + 1 < right) {
    int mid = left + (right - left) / 2;
    if (mid % 2 == 1) mid--;
    if (nums[mid] == nums[mid + 1]) {
        left = mid + 2;
    } else {
        right = mid;
    }
}
// 退出时 left 和 right 只差 0 或 1，需要手动判断
if (left == right) return nums[left];
return nums[left] == nums[left+1] ? nums[right] : nums[left];
    }
}
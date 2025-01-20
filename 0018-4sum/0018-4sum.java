import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();
        Arrays.sort(nums); // Sort the array

        kSum(nums, 4, 0, (long) target, res, quad);
        return res;
    }

    private void kSum(int[] nums, int k, int start, long target, List<List<Integer>> res, List<Integer> quad) {
        // Base case: 2 Sum
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>(quad);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return;
        }

        // Recursive case: reduce to (k-1) Sum
        for (int i = start; i < nums.length - (k - 1); i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            quad.add(nums[i]);
            kSum(nums, k - 1, i + 1, target - nums[i], res, quad);
            quad.remove(quad.size() - 1); // Backtrack
        }
    }
}


class Solution {
    public int countSubarrays(int[] nums, int k) {
           int n = nums.length;
    int pos = -1;
    for (int i = 0; i < n; i++) {
        if (nums[i] == k) pos = i;
    }

    Map<Integer,Integer> count = new HashMap<>();
    int sum = 0;
    count.put(0, 1); // 空前缀

    // 统计左边前缀和
    for (int i = pos - 1; i >= 0; i--) {
        sum += (nums[i] > k ? 1 : -1);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
    }

    int ans = 0;
    sum = 0;

    // 扫描右边并匹配
    for (int i = pos; i < n; i++) {
        if (nums[i] > k) sum += 1;
        else if (nums[i] < k) sum -= 1;

        ans += count.getOrDefault(-sum, 0);
        ans += count.getOrDefault(1 - sum, 0);
    }

    return ans;
    }
}
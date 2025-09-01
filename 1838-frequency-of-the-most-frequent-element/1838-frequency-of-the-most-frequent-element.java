class Solution {
    public int maxFrequency(int[] nums, int k) { 
        // 1. sort 
        Arrays.sort(nums); 

        // 2. sliding window 
        int left = 0, res = 0;
        long sum = 0; // 注意这里要用 long，防止溢出
        
        for (int i = 0; i < nums.length; i++) { 
            sum += nums[i]; 
            int len = i - left + 1; 

            // invalid to shrink window
            while ((long)nums[i] * len - sum > k && left <= i) { 
                sum -= nums[left++]; 
                len = i - left + 1; 
            }

            res = Math.max(res,  len); 
        }
        return res;
    }
}
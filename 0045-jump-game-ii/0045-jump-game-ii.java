class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int curRight = 0;
        int nextRight = 0;

        for (int i= 0; i < nums.length; i++) {
            if (curRight >= nums.length-1) return res;
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) {
                res++;
                curRight = nextRight;
            }
            
        } 
        return res;
        
    }
}
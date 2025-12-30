class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int curRight = 0; // 已建造的桥的右端点
        int nextRight = 0; // 下一座桥的右端点的最大值
        for (int i = 0; i < nums.length - 1; i++) {
            // 遍历的过程中，记录下一座桥的最远点
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) { // 无路可走，必须建桥
                curRight = nextRight; // 建桥后，最远可以到达 next_right
                ans++;
                // if (curRight >= nums.length-1) return ans;
            }
        }
        return ans;
    }
}
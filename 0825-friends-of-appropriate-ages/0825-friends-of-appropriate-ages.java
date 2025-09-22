class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121]; // 统计每个年龄出现次数
        for (int age : ages) {
            count[age]++;
        }

        // 前缀和数组
        int[] prefix = new int[121];
        for (int i = 1; i <= 120; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }

        int res = 0;
        for (int age = 15; age <= 120; age++) {
            if (count[age] == 0) continue;

            int minAge = (int)(0.5 * age + 7);
            int maxAge = age;

            // 区间 [minAge+1, maxAge] 的人数
            int totalInRange = prefix[maxAge] - prefix[minAge];

            // 自己不能给自己发请求 → count[age] * (totalInRange - 1)
            res += count[age] * (totalInRange - 1);
        }
        return res;
    }
}

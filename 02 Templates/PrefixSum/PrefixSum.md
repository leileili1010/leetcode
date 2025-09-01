# Prefix Sum

## basics
- 定义 prefixSum[i] = 前i个数之和（index from 0 to i-1)
- index from i to j 这一区间的和 = prefixSum[j+1] - prefixSum[i]
- O(N) construct, 之后就O(1) 计算
- 用于解决subarray问题
    - 长度为n的数组，有O(n^2) subarray and O(2^n) subsequence
- prefixsum只能用到连续的数组
    - subsequence 不能用prefixsum, 要用dp

```java
private int[] getPrefixSum(int[] nums) {
    int[] prefixSum = new int[nums.length+1];
    prefixSum[0] = 0;
    for (int i = 0; i < nums.length; i++) {
        prefixSum[i+1] = prefixSum[i] + nums[i]
    }
    return prefixSum;
}
```

## Tricks
### 如何更新HashMap<Integer, Integer>
- 求count map存的是<sum, count>, 每一次loop都要更新map, e.g LC 974
- 求maxLen, map存的是<sum, index>, 只有当!map.containsKey(sum), sum是当前计算的prefixSum, 才需要更新map index, e.g 526
- 求minLen, 每一轮都要更新map, e.g 560
- 求subarray sum是否能被k整除或者是否是k的倍数，map存的是余数而不是sum
    - 数组里面有负数： remainder = ((sum % k) + k) % k
    - 没有负数： remainder = sum % k
- 数组里面只有 0 和 1， 解某些题可以考虑把0当成-1
- Range sum: 考虑差分数组 和 输出 prefixsum数组， e.g 370, 1094
- sliding window 和 prefixSum + HashMap 区别
    - HashMap 用于处理equals k的情况
    - sliding window 处理 <= k情况， 所以我们可以用 atMost(k) - atMost(k-1) 来求出 equals k的count, e.g 930



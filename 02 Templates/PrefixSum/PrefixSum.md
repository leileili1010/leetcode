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


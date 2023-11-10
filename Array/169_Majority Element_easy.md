# 169. Majority Element

[Leetcode 169 (Easy)][169]

[169]: https://leetcode.com/problems/majority-element/

```java
// optimized appraoch




// Lei's approach
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int key = nums[0];
        for (Map.Entry<Integer, Integer> e:map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                key = e.getKey();
            }
        }
        return key;
    }
}
```
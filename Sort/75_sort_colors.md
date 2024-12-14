# 75. Sort Colors

[Leetcode 75 (Medium)][75]

[75]: https://leetcode.com/problems/sort-colors/

## Approach 1: using array to count numbers
- using array to count numbers (much faster than HashMap)
- update the original array
- time: O(n)
- space: O(1);

![alt text](image-1.png)

```java
class Solution {
    public void sortColors(int[] nums) {
        // use arr not hashmap to save count;
        int[] countColor = new int[3];
        int idx = 0;

        for (int num: nums) {
            countColor[num]++;
        }

        for (int i = 0; i <= 2; i++) {
                int count = countColor[i];
                while (count > 0) {
                    nums[idx++] = i;
                    count--;
                }
            
        }
    }
}
```

## Approach 2: partition

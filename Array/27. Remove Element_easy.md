# 27. Remove Element

[Leetcode 27 (Easy)][27]

[27]: https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150


```java
// Two pointers
// slow points to the index of the updated array;
// fast points to the ele needed for the updated array (i.e. ele != val)
class Solution {
    public int removeElement(int[] nums, int val) {
       int slow = 0;
    
       for (int fast = 0; fast < nums.length; fast++) {
           if (nums[fast] != val) {
               nums[slow] = nums[fast];
               slow++;
           }
       }
       return slow;
    }
}
// 时间复杂度：O(n)
// 空间复杂度：O(1)
```

```java
// 暴力解法 - 双重 for loop
class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i+1; j < size; j++) {
                    nums[j-1] = nums[j];
                }
                i--; // i 要往前移动一位，不然会漏过元素
                size--; //delete element之后array size 变小
            }
        }
        return size;
    }
}

// 时间复杂度：O(n^2)
// 空间复杂度：O(1)
```
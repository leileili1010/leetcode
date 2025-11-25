# 75. Sort Colors

[Leetcode 75 (Medium)][75]

[75]: https://leetcode.com/problems/sort-colors/

## Approach 1: using array to count numbers - counting sort (避免用这种方法)
- using array to count numbers (much faster than HashMap)
- update the original array
- time: O(n)
- space: O(1);
- 排序是避免用counting sort, 这是基于value的排序，我们最好写基于比较的排序

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
## Approach 2: partition 两次
- 3个值， partition 两次，4个值partition 3 次
    - 第一次partition: 比1小的和比1大的分开
    - 第二次partition: 比2小的和比2大的分开
- time: O(n)
- space: O(1);

![alt text](image-2.png)
```java
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int wall = partition(nums, -1, 1);
        partition(nums, wall, 2);
    }

    public int partition(int[] nums, int wall, int pivot) {
        int pointer = wall+1;
        int end = nums.length-1;

        while (pointer <= end) {
            if (nums[pointer] < pivot) {
                swap(nums, ++wall, pointer);
            } 
            pointer++;
        }

        return wall;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// partition 另一种写法
class Solution {
    public void sortColors(int[] nums) {
        int start = partition(nums, 0, 0);
        partition(nums, start, 1);
    }

    private int partition(int[] nums, int start, int k) {
        int n = nums.length, left = start, right = n-1;
        while (left <= right) {
            while (left <= right && nums[left] <= k) {
                left++;
            }

            while (left <= right && nums[right] > k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return left;
    }
}
```

## Approach 3: 3 pointers + only 1 loop
- This is not a very good method becuase unlike #1 & #2 approach that you can easily understand and apply to other problems, this is kinda hard to understand. 
- time: O(n), 
- Space: O(1)

```java
// 简单好理解写法
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;

        for (int i = 0; i <= right; i++){
            if (nums[i] == 0 && i > left) {
                swap(nums, left++, i--);
            } else if (nums[i] == 2 && i < right) {
                swap(nums, right--, i--);
            }
        }
    }

     private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 另一种不好理解的写法
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int pointer0 = -1;
        int pointer2 = nums.length;
        int idx = 0;

        while (idx < pointer2) {
            int cur = nums[idx];
            if (cur == 2) {
                swap(nums, idx--, --pointer2);
                // idx--因为交换过来的可能是1 or 0 还要在处理    
            } else if (cur == 0) {
                swap(nums, idx, ++pointer0);
                // 这里没有idx--, 因为交换过来的只可能是1， 没必要处理，如果是2，早就已经移到后面去了，idx从左走到右，它左边只可能是 <=1的
            }
            idx++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
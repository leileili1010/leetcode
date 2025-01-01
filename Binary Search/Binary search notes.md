# Binary Search 

![alt text](image-5.png)

![alt text](<屏幕截图 2024-12-30 100112.png>)

![alt text](<屏幕截图 2024-12-30 100636.png>)

- time: O(logN);

## Version 1
```java
// non-recursion
public static int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid+1;
            } else if (nums[mid] < target ) {
                left = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

// recursion
public static int binarySearch2(int[] nums, target) {
     public static int binarySearch3(int[] nums, int start, int end, int target) {
        int mid = start + (end - start)/2;

        if (start > end) {
            return -1;
        }

        if (nums[mid] > target) {
            return binarySearch3(nums, start, mid-1, target);
        }

        if (nums[mid] < target) {
            return binarySearch3(nums, mid+1, end, target);
        }

        return mid;
    }
}
```

## Version 2
```java
public static int binarySearch1(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target ) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
```


## Version 3

- 用于解决数组中有重复数字然后需要返回第一个或者最后出现的target

```java
public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // 如果求的是第一个出现的target， 把这行和下面那行对调
        if (nums[end] == target) {
            return end;
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
```

## 题型总结一
- 在排序的数据集上进行二分
    - 一般会给你一个数组，让你找数组中第一个/最后一个满足某个条件的位置
    - OOOO...OOXX...XXXX
![alt text](<屏幕截图 2024-12-30 120156.png>)

## 题型总结二
- 在未排序的数据集上进行二分
    - 无法找到一个条件，形成OOXX的模型
    - 但可以根据判断， 保留下有解的那一半或者去掉无解的那一半
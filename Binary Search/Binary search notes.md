# Binary Search 

![alt text](image-5.png)

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
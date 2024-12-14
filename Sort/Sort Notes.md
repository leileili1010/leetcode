- Quick Sort

```java
 public static void sortInt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        // start == end, 只有一个数字，直接return
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = nums[left + (right - left)/2]; // 避免overflow;

        // must to be <=, if left < right, will lead to stack overflow. 当两个指针重合时，比较一次各自走一步， = 保证两个指针错开
        while (left <= right) {
            while (left <= right && nums[left] < pivot) { // 此处不能 =， 如果有 = ， 一个数组全是1，出现stack overflow
                left++;
            }

            while (left <= right && nums[right] > pivot) { // 此处不能 =
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums,left, end);
    }

```

![alt text](image.png)
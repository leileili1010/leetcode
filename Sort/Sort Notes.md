```java
 public static void sortInt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = nums[(left + right)/2];

        // must to be <=, if left < right, will lead to stackoverflow
        while (left <= right) {
            while (left <= right && nums[left] < pivot) { // 此处不能 =
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
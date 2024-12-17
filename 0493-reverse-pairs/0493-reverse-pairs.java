class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];  // Temporary array for merging
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;  // No pairs if the subarray has one or fewer elements
        }
        
        int mid = start + (end - start) / 2;
        
        int count = 0;
        
        // Count reverse pairs in the left and right halves
        count += mergeSort(nums, start, mid, temp);
        count += mergeSort(nums, mid + 1, end, temp);
        
        // Count reverse pairs between the left and right halves while merging
        count += merge(nums, start, mid + 1, end, temp);
        
        return count;
    }

    private int merge(int[] nums, int leftStart, int rightStart, int end, int[] temp) {
        int count = 0;
        int idx = leftStart;
        int mid = rightStart - 1;
        int j = rightStart;
        
        // Count reverse pairs: for each element in the left half, find how many in the right half
        for (int i = leftStart; i <= mid; i++) {
            while (j <= end && nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += (j - rightStart);  // All elements from rightStart to j-1 are valid pairs
        }

        // Merge two sorted halves
        int leftIdx = leftStart, rightIdx = rightStart;
        while (leftIdx <= mid && rightIdx <= end) {
            if (nums[leftIdx] <= nums[rightIdx]) {
                temp[idx++] = nums[leftIdx++];
            } else {
                temp[idx++] = nums[rightIdx++];
            }
        }
        
        // Copy remaining elements from left half
        while (leftIdx <= mid) {
            temp[idx++] = nums[leftIdx++];
        }
        
        // Copy remaining elements from right half
        while (rightIdx <= end) {
            temp[idx++] = nums[rightIdx++];
        }
        
        // Copy the sorted array back into the original array
        for (int i = leftStart; i <= end; i++) {
            nums[i] = temp[i];
        }
        
        return count;
    }
}

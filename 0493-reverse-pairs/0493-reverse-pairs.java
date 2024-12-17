class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1, temp);
    }

    private int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }

        int sum = 0;
        int mid = start + (end-start)/2;
        sum += mergeSort(nums, start, mid, temp);
        sum += mergeSort(nums, mid+1, end, temp);
        sum += merge(nums, start, end, temp);
        return sum;
    }

    private int merge(int[] nums, int start, int end, int[] temp) {
        int leftIdx = start;
        int mid = start + (end-start)/2;
        int rightIdx = mid+1;
        int idx = leftIdx;
        int count = 0;

        while (leftIdx <= mid && rightIdx <= end) {
            if ((long)nums[leftIdx] > 2L * nums[rightIdx]) {
                count += mid - leftIdx +1;
                rightIdx++;
            } else {
                leftIdx++;
            }
        
        }
        
        leftIdx = start;
        rightIdx = mid+1;
        while (leftIdx <= mid && rightIdx <= end) {
            if (nums[leftIdx] <= nums[rightIdx]) {
                temp[idx++] = nums[leftIdx++];
            } else {
                temp[idx++] = nums[rightIdx++];
            }
        }

        while (leftIdx <= mid) {
            temp[idx++] = nums[leftIdx++];
        }

        while (rightIdx <= end) {
            temp[idx++] = nums[rightIdx++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }

        return count;
    } 
}
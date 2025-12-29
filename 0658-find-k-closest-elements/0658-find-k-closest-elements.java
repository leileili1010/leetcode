class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 比较窗口左边界外的一个元素和右边界内的一个元素
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = low; i < low + k; i++) res.add(arr[i]);
        return res;
    }
}
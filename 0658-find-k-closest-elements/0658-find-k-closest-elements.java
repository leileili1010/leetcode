class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = binarySearch(arr, x);
        int right = left + 1;
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        while (k > 0) {

            if (left < 0) {
                res.add(arr[right]);
                right++;
            } else if (right >= n) {
                res.add(0, arr[left]);
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                res.add(0, arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }

            k--;
        }
        return res;
    }

    private int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length-1;
        int res = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (arr[mid] <= x) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid-1;
            }
        }
        return res;
    } 
}
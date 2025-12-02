class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // in a sorted (ascending order) array
        // find k closest numbers to x, in ascending order

        List<Integer> res = new ArrayList<>(); // must be in ascending order
        int left = binarySearch(arr, x);
        int right = left + 1;

        for (int i = 0; i < k; i++) {
            if (isLeftCloser(left, right, arr, x)) {
                res.add(0, arr[left--]);
            } else {
                res.add(arr[right++]);
            }
        }
        return res;
    }

    private int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length-1;
        int res = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (arr[mid] <= x) {
                res = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }  
        }
        return res;
    }

    private boolean isLeftCloser(int left, int right, int[] arr, int x) {
        if (left < 0) return false;
        if (right >= arr.length) return true;
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x); 
    }
}
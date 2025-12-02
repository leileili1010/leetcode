class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // use binary search to find left side next to which we can inserch x
        // use two pointers to go against each other to find the closer one and add to res List

        List<Integer> res = new ArrayList<>();
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

    private int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        
        while (left <= right) {
            int mid = left + (right-left)/2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return right;
    }

    private boolean isLeftCloser(int left, int right, int[] arr, int x) {
        if (left < 0) return false;
        if (right >= arr.length) return true;
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x); 
    }
}
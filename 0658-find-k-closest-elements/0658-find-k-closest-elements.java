class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        int right = binarySearch(arr, x); //0
        int left = right-1; 
        int n = arr.length; //6

        while ((left >= 0 || right < n) && k > 0) {
            if (left >= 0 && k > 0 && (right >= n || Math.abs(arr[left]-x) >= Math.abs(arr[right]-x))) {
                res.add(0, arr[left--]);
            } else if (right < n && k > 0) {
                res.add(arr[right++]); 
            }
            k--; 
        }

        return res;
    }

    private int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length;

        while (start < end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > target) {
                end = mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return start;
    }
}
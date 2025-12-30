class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = binarySearch(arr, x);
        int right = left + 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

     private int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length-1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}


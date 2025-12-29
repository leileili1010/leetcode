class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = findInsert(arr, x); // the biggest number <= x
        int right = left + 1;

        while (left >= 0 || right < arr.length && k > 0) {
            if (left >= 0 && x-arr[left] <= arr[right]-x) {
                res.add(0, arr[left--]);
            } else {
                res.add(arr[right++]);
            }
            k--;
        }
        return res;
    }

    private int findInsert(int[] arr, int x) {
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
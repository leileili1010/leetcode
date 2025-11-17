class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;
        
        // 1. find the first decreasing digit from right
        int i = len - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) return -1; // fully non-increasing
        
        // 2. find the smallest digit > arr[i] from the right
        int j = len - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        
        // 3. swap digits[i] and digits[j]
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        // 4. reverse the suffix
        reverse(arr, i + 1, len - 1);
        
        // 5. check overflow
        long num = Long.parseLong(new String(arr));
        return num > Integer.MAX_VALUE ? -1 : (int) num;
    }
    
    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

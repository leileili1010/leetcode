class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int N = numbers.length;
        int left = 0, right = N-1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[] {left+1, right+1};
            }
        }
        return new int[]{};
    }
}
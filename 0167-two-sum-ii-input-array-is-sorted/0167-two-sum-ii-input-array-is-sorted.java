class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // sorted, 1-indexed array
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            if (map.containsKey(target-curr)) {
                return new int[]{map.get(target-curr)+1, i+1};
            }
            map.put(curr, i);
        }
        return new int[2];
    }
}
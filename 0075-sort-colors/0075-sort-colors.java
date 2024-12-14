class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int i = 0; i <= 2; i++) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                while (count > 0) {
                    nums[idx++] = i;
                    count--;
                }
            }
        }
    }
}
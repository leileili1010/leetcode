class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(new int[] {nums[i], i});
        }

        Collections.sort(list, (a, b) -> (a[0] - b[0]));

        int i = 0, j = nums.length-1;
 
        while (i < j) {
            int num1 = list.get(i)[0];
            int num2 = list.get(j)[0];

            if (num1 + num2 > target) {
                j--;
            } else if (num1 + num2 < target) {
                i++;
            } else {
                return new int[] {list.get(i)[1], list.get(j)[1]};
            } 

        }
        return new int[] {-1,-1};

    }
}
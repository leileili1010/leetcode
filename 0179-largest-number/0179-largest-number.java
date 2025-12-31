class Solution {
    public String largestNumber(int[] nums) {
        // 1. 转成字符串数组
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // 2. 自定义排序
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 3. 特殊情况：全是 0
        if (arr[0].equals("0")) return "0";

        // 4. 拼接结果
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}

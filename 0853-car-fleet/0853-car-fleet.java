class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < position.length; i++) {
            arr[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(arr, (a,b) -> (b[0]-a[0]));

        for (int i = 0; i < arr.length; i++) {
            double time2 = (double)(target-arr[i][0])/arr[i][1];
            if (stack.isEmpty()) {
                stack.push(time2);
                continue;
            }
            double time1 = stack.peek();
            if (time2 > time1) stack.push(time2);
        }
        return stack.size();
    }
}
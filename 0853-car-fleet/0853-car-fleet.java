class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[][] arr = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            arr[i] = (new int[]{position[i], speed[i]});
        }
        Arrays.sort(arr, (a,b) -> (a[0] == b[0]? b[1]-a[1]: a[0]-b[0]));

        for (int i = position.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            double time1 = (double)(target-stack.peek()[0])/stack.peek()[1];
            double time2 = (double)(target-arr[i][0])/arr[i][1];
            if (time2 > time1) {
                stack.push(arr[i]);
            }

        }
        return stack.size();
    }
}
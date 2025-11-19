class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];
        int[] res = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] == b[1]? a[2]-b[2]: a[1]-b[1]); // 最小堆：先 processTime, 再 index
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // 按 enqueueTime 排序
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0; // task pointer
        int i = 0; // res pointer;
        long time = 0;

        while (idx < n) {
            
            // equeue tasks that are befor or righ on time
            while (i < n &&  arr[i][0] <= time) {
                minHeap.offer(arr[i++]);
            }

            if (minHeap.isEmpty()) {
                time = arr[i][0];
                continue;
            }

            // 从堆中取出最优任务
            int[] cur = minHeap.poll();
            res[idx++] = cur[2];

            // 执行任务，更新时间
            time += cur[1];
        }
        return res;
    }
}
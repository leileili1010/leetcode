class Solution {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int maxHeapSize = 0, minHeapSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // 1. 初始化前 k 个元素
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        result[0] = getMedian(k);

        // 2. 滑动窗口
        for (int i = k; i < n; i++) {
            int newNum = nums[i];        // 进入窗口的新元素
            int outNum = nums[i - k];    // 离开窗口的旧元素

            addNum(newNum);
            removeNum(outNum);           // 延迟删除

            result[i - k + 1] = getMedian(k);
        }

        return result;
    }

    // 插入元素
    private void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            maxHeapSize++;
        } else {
            minHeap.offer(num);
            minHeapSize++;
        }
        balanceHeaps();
    }

       // 平衡两个堆 (保证 maxHeapSize >= minHeapSize，且差值不超过 1)
    private void balanceHeaps() {
        if (maxHeapSize > minHeapSize + 1) {
            minHeap.offer(maxHeap.poll());
            maxHeapSize--;
            minHeapSize++;
            prune(maxHeap);
        } else if (maxHeapSize < minHeapSize) {
            maxHeap.offer(minHeap.poll());
            maxHeapSize++;
            minHeapSize--;
            prune(minHeap);
        }
    }

        // 清理堆顶的过期元素
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delayed.containsKey(heap.peek())) {
            int num = heap.peek();
            delayed.put(num, delayed.get(num) - 1);
            if (delayed.get(num) == 0) delayed.remove(num);
            heap.poll();
        }
    }

    // 延迟删除元素
    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= maxHeap.peek()) {
            maxHeapSize--;
            if (num == maxHeap.peek()) prune(maxHeap); // 如果刚好在堆顶，立刻清理
        } else {
            minHeapSize--;
            if (num == minHeap.peek()) prune(minHeap);
        }
        balanceHeaps();
    }


    // 获取中位数
    private double getMedian(int k) {
        if (k % 2 == 1) {
            return (double) maxHeap.peek();
        } else {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        }
    }
}
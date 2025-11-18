class Solution {
    private PriorityQueue<Integer> leftHalf;
    private PriorityQueue<Integer> rightHalf;
    private Map<Integer, Integer> delayed;
    private int leftHalfSize;
    private int rightHalfSize;

    public double[] medianSlidingWindow(int[] nums, int k) {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
        delayed = new HashMap<>(); // <number to be deleted, times>
        int n = nums.length;
        double[] res = new double[n-k+1];
        leftHalfSize = 0;
        rightHalfSize = 0;

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        } 

        res[0] = getMedian(k);

        for (int i = k; i < n; i++) {
            int newNum = nums[i];
            int oldNum = nums[i-k];
            
            addNum(newNum);
            removeNum(oldNum);

            res[i-k+1] = getMedian(k);
        }
        return res;
    }

    private void addNum(int num) {
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.offer(num);
            leftHalfSize++;
        } else {
            rightHalf.offer(num);
            rightHalfSize++;
        }
        balanceHeaps(); // balance after adding 
    }

    private void balanceHeaps() {
        if (leftHalfSize > rightHalfSize + 1) {
            rightHalf.offer(leftHalf.poll());
            leftHalfSize--;
            rightHalfSize++;
            prune(leftHalf);
        } else if (leftHalfSize < rightHalfSize) {
            leftHalf.offer(rightHalf.poll());
            leftHalfSize++;
            rightHalfSize--;
            prune(rightHalf);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delayed.containsKey(heap.peek())) {
            int num = heap.peek();
            delayed.put(num, delayed.get(num)-1);
            if (delayed.get(num) == 0) delayed.remove(num);
            heap.poll();
        }
    }

    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0)+1);
        
        if (num <= leftHalf.peek()) {
            leftHalfSize--;
            if (num == leftHalf.peek()) prune(leftHalf);
        } else {
            rightHalfSize--;
            if (num == rightHalf.peek()) prune(rightHalf);
        }
        balanceHeaps(); // balance after deleting
    }

    private double getMedian(int k) {
        if (k % 2 ==1) {
            return (double)leftHalf.peek();
        }
        return ((double)leftHalf.peek() + rightHalf.peek())/2.0;
    }
}
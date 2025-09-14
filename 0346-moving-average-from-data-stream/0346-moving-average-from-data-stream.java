class MovingAverage {
    private Deque<Integer> window;
    private int k;
    private double sum;

    public MovingAverage(int size) {
        this.k = size;
        this.sum = 0;
        this.window = new ArrayDeque<>();
    }

    public double next(int val) {
        window.offer(val);
        sum += val;

        if (window.size() > k) {
            sum -= window.poll(); // 移除最早的数
        }

        return sum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
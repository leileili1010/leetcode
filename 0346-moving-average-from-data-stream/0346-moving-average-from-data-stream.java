class MovingAverage {
    private Queue<Integer> window;
    private int maxSize;
    private double sum;

    public MovingAverage(int size) {
        this.window = new LinkedList<>();
        this.maxSize = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        window.offer(val);
        sum += val;

        if (window.size() > maxSize) {
            sum -= window.poll();
        }

        return sum / window.size();
    }
}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
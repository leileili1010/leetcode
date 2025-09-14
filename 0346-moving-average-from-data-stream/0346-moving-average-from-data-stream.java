class MovingAverage {
    List<Integer> prefixSum;
    int sum;
    int k;

    public MovingAverage(int size) {
        k = size;
        sum = 0;
        prefixSum = new ArrayList<>();
        
    }
    
    public double next(int val) {
        sum += val;
        prefixSum.add(sum);
        int size = prefixSum.size();
        if (size <= k) return (double)prefixSum.get(size-1) / size;
        return (double)(prefixSum.get(size-1) - prefixSum.get(size-1-k)) / k;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
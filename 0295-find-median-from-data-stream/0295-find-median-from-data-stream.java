class MedianFinder {
    private PriorityQueue<Integer> leftHalf;
    private PriorityQueue<Integer> rightHalf;

    public MedianFinder() {
        leftHalf = new PriorityQueue<>();
        rightHalf = new PriorityQueue<>((a,b) -> (b - a));
    }
    
    public void addNum(int num) {
        if (leftHalf.isEmpty()) {
            leftHalf.offer(num);
        } else if (leftHalf.size() == rightHalf.size()) {
            rightHalf.offer(num);
            leftHalf.offer(rightHalf.poll());
        } else {
            leftHalf.offer(num);
            rightHalf.offer(leftHalf.poll());
        }
    }
    
    public double findMedian() {
        int m = leftHalf.size();
        int n = rightHalf.size();
        return m > n? leftHalf.peek(): (leftHalf.peek() + rightHalf.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
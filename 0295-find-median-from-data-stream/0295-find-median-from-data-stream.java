class MedianFinder {
    private PriorityQueue<Integer> leftHalf;
    private PriorityQueue<Integer> rightHalf;

    public MedianFinder() {
        leftHalf = new PriorityQueue<>((a, b) -> b-a);
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftHalf.add(num);
        rightHalf.add(leftHalf.poll());

        if (rightHalf.size() > leftHalf.size()) {
            leftHalf.add(rightHalf.poll());
        }
    }
    
    public double findMedian() {
        return rightHalf.size() == leftHalf.size()? (rightHalf.peek() + leftHalf.peek())/2.0: leftHalf.peek(); 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class SparseVector {
    List<int[]> list;

    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[] {i, nums[i]});
            }
        } 
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0;
        for (int[] pair: vec.list) {
            int idx = pair[0];
            int value = pair[1];
            dotProduct += value * binarySearch(idx, 0, this.list.size()-1);
        }

        return dotProduct;
    }

    private int binarySearch(int idx, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (this.list.get(mid)[0] == idx) {
                return this.list.get(mid)[1];
            } 
            if (this.list.get(mid)[0] > idx) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
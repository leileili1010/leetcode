class SparseVector {
    private Map<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (this.map.size() > vec.map.size()) return vec.dotProduct(this);
        int res = 0;
        
        for (int key: this.map.keySet()) {
            if (vec.map.containsKey(key)) {
                res += this.map.get(key) * vec.map.get(key);
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
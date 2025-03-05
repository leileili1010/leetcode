class SparseVector {
    List<int[]> list;
    
    SparseVector(int[] nums) {
        this.list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (this.list.size() > vec.list.size()) return vec.dotProduct(this);
        int res = 0;

        for (int[] pair: this.list) {
            int idx = pair[0];
            int value = pair[1];
            res += value * binarySearch(vec.list, idx, 0, vec.list.size()-1);
        }
        return res;
    }

    private int binarySearch(List<int[]> list, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            int idx = list.get(mid)[0];
            if (idx == target) {
                return list.get(mid)[1];
            } else if (idx < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
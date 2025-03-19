class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
TreeMap<Integer, Integer> map = new TreeMap<>();
int n = nums.length;
for(int i=0;i<k;i++) map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
int[] ans = new int[n-k+1];
ans[0] = map.lastKey();
for(int i=k;i<n;i++) {
map.put(nums[i-k], map.get(nums[i-k]) -1);
if(map.get(nums[i-k])==0) map.remove(nums[i-k]);
map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
ans[i-k+1] = map.lastKey();
}
return ans;
}
}
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> top = new TreeSet<>();
        for (int n : nums) {
            top.add(n);
            if (top.size() > 3) top.pollFirst(); // remove smallest
        }
        return top.size() == 3 ? top.first() : top.last();
    }
}
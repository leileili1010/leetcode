class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2,2);
        return steps(n, map);
    }

    private int steps(int n, HashMap<Integer, Integer> map) {
       if (map.containsKey(n)) {
            return map.get(n);
       }

       int steps = steps(n-1, map) + steps(n-2, map);
       map.put(n, steps);
       return steps;
    }
}
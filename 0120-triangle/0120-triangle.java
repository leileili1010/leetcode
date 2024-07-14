class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        return dfs(triangle, 0, 0, map);
    }

    public int dfs(List<List<Integer>> triangle, int x, int y, HashMap<List<Integer>, Integer> map) {
        if (x == triangle.size()) {
            return 0;
        }

        List<Integer> cur = new ArrayList<>(Arrays.asList(x, y));
        if (map.containsKey(cur)) {
            return map.get(cur);
        }

        int left = dfs(triangle, x+1, y, map);
        int right = dfs(triangle, x+1, y+1, map);
       
        map.put(cur, Math.min(left, right) + triangle.get(x).get(y));
        return map.get(cur); 
    }
}
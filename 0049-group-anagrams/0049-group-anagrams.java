class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map: key is the sorted str and value is a list of strs
        // loop through strs, put str in map with the corresponding key
        // loop through map to get the value (list of each key), add to res
        
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        for (String key: map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
    }
}
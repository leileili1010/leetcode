class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String str: strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        for (String key: map.keySet()) {
            res.add(map.get(key));
        } 

        return res;
    }
}
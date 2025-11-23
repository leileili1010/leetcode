class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String newStr = new String(letters);
            map.computeIfAbsent(newStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList(map.values());
    }
}
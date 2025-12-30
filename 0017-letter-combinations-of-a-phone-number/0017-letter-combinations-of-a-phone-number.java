class Solution {
    public List<String> letterCombinations(String digits) {
        String[] cells = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        dfs(digits, cells, res, new StringBuilder(), 0);
        return res;
    }
    
    private void dfs(String digits, String[] cells, List<String> res, StringBuilder sb, int k) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        for (char c: cells[digits.charAt(k)-'0'].toCharArray()) {
            sb.append(c);
            dfs(digits, cells, res, sb, k+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
class Solution {
    
    private String[] keyboard = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
        
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int digit = digits.charAt(index) - '0';
        for (char c: keyboard[digit].toCharArray()) {
            sb.append(c);
            dfs(digits, index+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
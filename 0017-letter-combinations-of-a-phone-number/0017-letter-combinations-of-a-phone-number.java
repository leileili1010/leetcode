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

        dfs(digits, 0, "", res);
        return res;
    }

    private void dfs(String digits, int index, String combination, List<String> res) {
        if (combination.length() == digits.length()) {
            res.add(combination);
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (char c: keyboard[digit].toCharArray()) {
            dfs(digits, index+1, combination + c, res);
        }
    }
}
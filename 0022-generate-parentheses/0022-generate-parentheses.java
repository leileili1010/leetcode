class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String current, int open, int close, int max) {
        // base case : valid string of length 2n
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }

        // add '(' if open count is less than max
        if (open < max) {
            backtrack(res, current+"(", open+1, close, max);
        }

        // add ')' if close count is less than count
        if (close < open) {
            backtrack(res, current+")", open, close+1, max);
        }
    }
}
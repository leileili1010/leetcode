class Solution {
    private boolean[] used;
    private Set<Integer> set;

    public int totalNumbers(int[] digits) {
        used = new boolean[digits.length];
        set = new HashSet<>();
        dfs(digits, 0, 0);
        return set.size();
    }

    private void dfs(int[] digits, int pos, int num) {
        if (pos == 3) {
            set.add(num);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            int digit = digits[i];
            
            if (pos == 0 && digit == 0) continue;
            if (pos == 2 && digit % 2 != 0) continue;

            used[i] = true;
            dfs(digits, pos+1, num * 10 + digit);
            used[i] = false;
        }
    }
}
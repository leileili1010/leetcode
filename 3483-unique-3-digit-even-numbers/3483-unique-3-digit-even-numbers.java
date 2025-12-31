class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) { // 个位数
            int a = digits[i];
            if (a % 2 > 0) {
                continue;
            }
            for (int j = 0; j < n; j++) { // 十位数
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < n; k++) { // 百位数
                    int c = digits[k];
                    if (c == 0 || k == i || k == j) {
                        continue;
                    }
                    set.add(c * 100 + digits[j] * 10 + a);
                }
            }
        }
        return set.size();
    }
}
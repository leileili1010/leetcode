class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBalanced(num)) return num;
            num++;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0) return false; // \U0001f6ab 出现0直接排除
            count[digit]++;
            temp /= 10;
        }

        for (int i = 1; i <= 9; i++) {
            if (count[i] != 0 && count[i] != i)
                return false;
        }
        return true;
    }
}


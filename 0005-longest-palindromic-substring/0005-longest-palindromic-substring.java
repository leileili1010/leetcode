class Solution {
    public String longestPalindrome(String s) {
        int[] startAndLength = new int[2];

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, 0, startAndLength);
            expand(s, i, 1, startAndLength);

        }
        return s.substring(startAndLength[0], startAndLength[0]+startAndLength[1]);
    }

    private void expand(String s, int idx, int offset, int[] startAndLength) {
        int left = idx, right = idx + offset;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left++;
        right--;
        if (right-left+1 > startAndLength[1]) {
            startAndLength[0] = left;
            startAndLength[1] = right-left+1;
        }
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int[] startAndLength = new int[2];

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, 0, startAndLength); // for odd
            expand(s, i, 1, startAndLength); // for even
        }

        int start = startAndLength[0];
        int len = startAndLength[1];
        return s.substring(start, start + len);
    }

    private void expand(String s, int start, int offset, int[] startAndLength) {
        int left = start, right = start + offset;

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
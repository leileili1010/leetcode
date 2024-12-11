class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return ifValid(i+1, j, s) || ifValid(i, j-1, s);
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean ifValid(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
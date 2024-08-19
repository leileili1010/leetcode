class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return checkPalindrome(s, left+1, right) || checkPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;        
    }

    public boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            while ( i < j && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
}
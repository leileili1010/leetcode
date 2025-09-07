class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        char[] palindromeChars = palindrome.toCharArray();

        for (int i = 0; i < n/2; i++) {
            if (palindromeChars[i] != 'a') {
                palindromeChars[i] = 'a';
                return String.valueOf(palindromeChars);
            }
        }
        palindromeChars[n-1] = 'b';
        return String.valueOf(palindromeChars);
        
    }
}
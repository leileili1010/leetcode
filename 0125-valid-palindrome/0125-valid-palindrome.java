class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;

        while (i < j) {
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));

            if (!Character.isLetterOrDigit(left)) {
                i++;
            } else if (!Character.isLetterOrDigit(right)) {
                j--;
            } else if (left != right) {
               
                    return false;
                
            } else {
                i++;
                j--;
            }
        }

        return true; 
    }
}
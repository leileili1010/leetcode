class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int i = 0;
        while (i < haystack.length()) {
            if ( haystack.charAt(i) != needle.charAt(0)) {
                i++;
            } else {
               if (haystack.length() - i < needle.length()) return -1;
               if (haystack.substring(i, i+needle.length()) == needle) {
                    return i;
               } else {
                    i++;
               }
            }
        }
        return -1;
    }
}
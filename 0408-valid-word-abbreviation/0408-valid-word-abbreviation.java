class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // Pointer for word
    int j = 0; // Pointer for abbr
    int wordLen = word.length();
    int abbrLen = abbr.length();

    while (i < wordLen && j < abbrLen) {
        if (Character.isDigit(abbr.charAt(j))) {
            if (abbr.charAt(j) == '0') return false; // Leading zero is invalid
            int num = 0;
            while (j < abbrLen && Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + (abbr.charAt(j) - '0');
                j++;
            }
            i += num; // Skip 'num' characters in word
        } else {
            if (word.charAt(i) != abbr.charAt(j)) return false;
            i++;
            j++;
        }
    }
    return i == wordLen && j == abbrLen;
        }
    
}
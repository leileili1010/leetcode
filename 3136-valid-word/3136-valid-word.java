class Solution {
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) return false;
        boolean hasVowel = false, hasConsonant = false;
        String vowels = "aeiouAEIOU";

        for (char c: word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
            if (!hasVowel && vowels.contains(String.valueOf(c))) hasVowel = true;
            if (!hasConsonant && !vowels.contains(String.valueOf(c))) hasConsonant = true;
        }
        return hasConsonant && hasVowel;
    }
}
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int n = goal.length();
        int[] freq = new int[26];
        boolean haveMultipleSameLetters = false;
        List<Integer> diff = new ArrayList<>();

        for (char c: goal.toCharArray()) {
            freq[c-'a']++;
            if (freq[c-'a'] >= 2) haveMultipleSameLetters = true;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) diff.add(i);
            if (diff.size() > 2) return false;
        }

        if (diff.size() == 0) {
            return haveMultipleSameLetters;
        }

        if (diff.size() == 2) {
            int i = diff.get(0);
            int j = diff.get(1);
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }

        return false;
    }
}
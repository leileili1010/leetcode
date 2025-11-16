class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diff = new ArrayList<>();
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff.add(i);
            if (diff.size() > 2) return false;
        }

        if (diff.size() == 0) return true;

        if (diff.size() == 2) {
            int i = diff.get(0);
            int j = diff.get(1);
            if (s1.charAt(i) == s2.charAt(j) && s2.charAt(i) == s1.charAt(j)) return true;
        }

        return false; 
    }
}
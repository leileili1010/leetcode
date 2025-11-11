class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // edge case
        for (int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            String cur = words[i];

            if (prev.contains(cur) && prev.length() > cur.length()) return false;

            int len = Math.min(cur.length(), prev.length());
            for (int j = 0; j < len; j++) {
                char c1 = prev.charAt(j);
                char c2 = cur.charAt(j);
                if ( c1 != c2 ) {
                    if( order.indexOf(c1) > order.indexOf(c2)) return false;
                    else break;
                } 
            }
        }
        return true;
    }
}
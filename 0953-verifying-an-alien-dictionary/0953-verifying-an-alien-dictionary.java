class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            String cur = words[i];

            if (prev.startsWith(cur) && prev.length() > cur.length()) return false;

            int len = Math.min(cur.length(), prev.length());
            for (int j = 0; j < len; j++) {
                char c1 = prev.charAt(j);
                char c2 = cur.charAt(j);
                if ( c1 != c2 ) {
                    if(orderMap[c1-'a'] > orderMap[c2-'a'] ) return false;
                    else break;
                } 
            }
        }
        return true;
    }
}
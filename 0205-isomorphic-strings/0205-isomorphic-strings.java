class Solution {
    public boolean isIsomorphic(String s, String t) {
        Character[] mapS = new Character[128];
        Character[] mapT = new Character[128];
        
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char x = s.charAt(i); 
            char y = t.charAt(i);
            
            if (mapS[x] != null && mapS[x] != y || mapT[y] != null && mapT[y] != x) {
                return false;
            }
            
            mapS[x] = y;
            mapT[y] = x;
        }
        return true;
    }
}

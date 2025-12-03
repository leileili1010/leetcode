class Solution {
    public String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        int need = 0;

        for (char c: t.toCharArray()) {
            if (cntT[c] == 0) need++;
            cntT[c]++;
        }

        int left = 0, hava = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];
            if (cntT[curr] > 0) {
                cntS[curr]++;
                if (cntS[curr] == cntT[curr]) hava++;
            }    

            while (hava == need) {
                if (i-left+1 < minLen) {
                    minStart = left;
                    minLen = i-left+1;
                }

                char lc = arr[left];
               
                if (cntT[lc] > 0) {
                    cntS[lc]--;
                    if (cntS[lc] < cntT[lc]) hava--;
                }  

                left++;
            }

        }

        return minLen == Integer.MAX_VALUE? "": s.substring(minStart, minStart+minLen);
    }
}
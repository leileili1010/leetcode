class Solution {
    public String minWindow(String s, String t) {
        // use two arries to count letter frequency
        // use sliding window
            // enter new letter, if tcount has it, update scount
            // if scount == tcount, validcount++;
            // while validcount == need, shrink window  
                // udpate minLen, minStart
                // when a letter leavs the window, udpate scount if tcount has it
        int[] cntT = new int[128];
        int[] cntS = new int[128];
        int need = 0;

        for (char c: t.toCharArray()) {
            if (cntT[c] == 0) need++;
            cntT[c]++;
        }

        char[] arr = s.toCharArray();
        int left = 0, have = 0, minStart = 0, minLen = arr.length+1;
        
        for (int i = 0; i < arr.length; i++) {
            char rc = arr[i];
            if (cntT[rc] > 0) {
                cntS[rc]++;
                if (cntS[rc] == cntT[rc]) have++;
            }

            while (have == need) {
                if (i-left+1 < minLen) {
                    minLen = i-left+1;
                    minStart = left;
                }
                char lc = arr[left];
                if (cntT[lc] > 0) {
                    cntS[lc]--;
                    if (cntS[lc] < cntT[lc]) have--;
                }

                left++;
            }
        }

        return minLen == arr.length+1? "": s.substring(minStart, minStart+minLen);
        
    }
}
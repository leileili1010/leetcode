class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for ( int i = 0; i < ans.length; i++) {
            ans[i] = bits(i);
        }
        return ans;
    }

    public int bits(int n) {
        int count = 0;
        
        while (n != 0) {
            if ( n % 2 == 1) {
                count++;
            }

            n = n / 2;
        }

        return count;
    }
}
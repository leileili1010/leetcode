class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int penality = 0;

        int minPenality = 0, res = 0;
        for (int i = 0; i < n; i++) {
            penality = penality + (customers.charAt(i) == 'N'? 1: -1);
            if (penality < minPenality) {
                minPenality = penality;
                res = i+1;
            }
        }
        return res;
    }
}
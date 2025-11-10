class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) return 1;
        
        Set<Integer> people = new HashSet<>();
        int[] count = new int[n+1]; 
        int judge = -1;

        for (int[] pair: trust) {
            int a = pair[0];
            int b = pair[1];
            people.add(a);
            count[b]++;
            if (count[b] == n-1) judge = b;
        }

        return people.contains(judge)? -1: judge;
    }
}
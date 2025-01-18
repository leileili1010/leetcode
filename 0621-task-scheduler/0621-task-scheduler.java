class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c-'A']++;
        }
        Arrays.sort(freq);

        int time = 0;
        while (freq[25] > 0) {
            int i = 0;
            while (i < n+1) {
                if(freq[25] == 0) break;
                int idx = 25-i;
                if (idx >= 0 && freq[idx] > 0) freq[idx]--;
                time++;
                i++;
            }   
            Arrays.sort(freq);
        }
        return time;
    }
}
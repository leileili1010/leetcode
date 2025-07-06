class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c-'A']++;
        }
        Arrays.sort(freq);

        int time = 0;
        while (freq[25] > 0) {//每一轮都会重新sort, 如果最大的freq都是0，说明tasks已经全部做完了
            int i = 0;
            while (i < n+1 && freq[25] > 0) {
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
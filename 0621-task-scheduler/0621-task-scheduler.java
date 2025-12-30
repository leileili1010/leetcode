class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. calculate freq for each tasks
        // 2. maxFreq and maxCount
        // 3. return Math.max((maxFreq - 1)*(n+1) + 3, tasks.length);

        int[] freq = new int[26];
        for (char task: tasks) freq[task - 'A']++;

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        int maxCount = 0;
        for (int f: freq) {
            if (f == maxFreq) maxCount++;
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1) + maxCount);
    }
}
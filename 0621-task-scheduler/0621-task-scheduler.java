class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. calculate freq for each tasks
        // 2. maxFreq and maxChar
        // 3. formular

        int[] freq = new int[26];
        for (char task: tasks) freq[task-'A']++;

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        int maxCount = 0; 
        for (int i = 0; i < 26; i++) {
            if (maxFreq == freq[i]) maxCount++;
        }

        return Math.max(tasks.length, (maxFreq-1) * (n+1) + maxCount);
    }
}
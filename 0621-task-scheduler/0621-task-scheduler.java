public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq); // sort in ascending order

        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n;

        // fill idle slots with the rest of the tasks
        for (int i = 24; i >= 0 && idleSlots > 0; i--) {
            idleSlots -= Math.min(freq[i], maxFreq - 1);
        }

        idleSlots = Math.max(0, idleSlots);

        return tasks.length + idleSlots;
    }
}
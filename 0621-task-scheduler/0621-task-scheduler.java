class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. calculate freq for each tasks
        int[] freq = new int[26];
        for (char task: tasks) freq[task-'A']++; 

        // 2. maxHeap<idx of freq> by freq
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        for (int f: freq) {
            if (f > 0) maxHeap.offer(f);
        }

        // 3. simulation
        int time = 0;
        while (!maxHeap.isEmpty()) {
            // for the current cycle
            int cycle = n + 1;
            int taskCount = 0;
            List<Integer> store = new ArrayList<>();

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int taskFreq = maxHeap.poll();
                if (--taskFreq  > 0) store.add(taskFreq);
                cycle--;
                taskCount++;
            }

            maxHeap.addAll(store);

            time += maxHeap.isEmpty()? taskCount: n+1;
        }
        return time;
    }
}
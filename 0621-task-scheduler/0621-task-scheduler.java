class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. calc freq for each letter
        // 2. put all freq in maxheap
        // 3. simulation
            // while maxheap is not empty
                // cycle = n + 1
                // taskCount
                // list to store processed tasks, put in maxHeap if > 0
                // time += maxHeap is empty? taskCount: n+1

        int[] freq = new int[26];
        for (char task: tasks) freq[task - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        for (int f: freq) {
            if (f > 0) maxHeap.add(f);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            int taskCount = 0;
            List<Integer> store = new ArrayList<>();

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                if (--task > 0) store.add(task);
                cycle--;
                taskCount++;
            }

            if (store.size() > 0) maxHeap.addAll(store);
            
            time += maxHeap.isEmpty()? taskCount: n + 1; 
        }
        return time;
    }
}
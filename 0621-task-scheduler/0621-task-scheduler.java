class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c: tasks) freq[c-'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        for (int num: freq) {
            if (num > 0) maxHeap.offer(num);
        }   

        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            int taskCount = 0;
            List<Integer> store = new ArrayList<>();

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                taskCount++;
                cycle--;
                if (--task > 0) store.add(task);
            }

            for (int num: store) maxHeap.offer(num);

            time += maxHeap.isEmpty()? taskCount: n+1;
        }
        return time;
    }
}
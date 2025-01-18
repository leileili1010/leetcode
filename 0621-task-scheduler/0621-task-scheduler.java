class Solution {
    public int leastInterval(char[] tasks, int n) {
        // construct frequency
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c-'A']++;
        }

        // construct maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        for (int num: freq) {
            if (num > 0) maxHeap.offer(num);
        }

        //
        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n+1;
            List<Integer> upcomingTasks = new ArrayList<>();
            int count = 0;
            while (cycle > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task--;
                count++;
                if (task > 0) upcomingTasks.add(task);
                cycle--;
            }

            for (int task: upcomingTasks) {
                maxHeap.offer(task);
            }

            time += maxHeap.isEmpty()? count: n+1;
        }

        return time;
    }
}
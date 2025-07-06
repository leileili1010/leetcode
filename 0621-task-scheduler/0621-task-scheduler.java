class Solution {
    public int leastInterval(char[] tasks, int n) {
        // step 1: construct frequency map
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c - 'A']++;
        }

        // step 2: contruct maxheap
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>((a,b) -> (b - a));
        for (int num: freq) {
            if (num > 0) maxHeap.offer(num);
        }

        // step 3
        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            
            while(cycle-- > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                taskCount++;
                task--;
                if (task > 0) store.add(task); //如果task == 0,就没必要再放入heap, 已经做完该种task了
            }

            for (int num: store) {
                maxHeap.offer(num);
            }

            // time += n+1 除了最后一轮，直接+该轮实际的task数
            time += maxHeap.isEmpty()? taskCount: n+1; // 这里不能+cycle, cycle ！= n+1;
        }
        return time;
    }
}
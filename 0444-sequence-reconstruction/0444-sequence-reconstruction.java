class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        List<Integer>[] graph = new List[n+1];
        int[] inDegree = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> sequence: sequences) {
            for (int i = 0; i < sequence.size(); i++) {
                if (i + 1 < sequence.size()) {
                    int from = sequence.get(i);
                    int to = sequence.get(i+1);
                    graph[from].add(to);
                    inDegree[to]++;
                }
            }
        }

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) que.add(i);
        } 

        int count = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            if (size > 1) return false;
            count++;
            int cur = que.poll();
            for (int next: graph[cur]) {
                inDegree[next]--;
                if (inDegree[next] == 0) que.offer(next);
            }

        }
        return count == n;
    }
}
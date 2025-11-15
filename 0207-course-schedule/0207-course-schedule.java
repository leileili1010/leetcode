class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        // build indegree
        // find nodes with 0 indegree, place in que
        // bfs
            // count number of nodes
        // return number of nodes == numcourses

        // 1. build indgree and graph
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre: prerequisites) {
            int start = pre[1], end = pre[0];
            indegree[end]++;
            graph[start].add(end);
        }

        // 2. find nodes with 0 indegree and put them in queue
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) que.offer(i);
        }

        // 3. bfs;
        int count = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            count++;

            for (int next: graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) que.offer(next);
            }
        }

        return count == numCourses;


        
    }
}
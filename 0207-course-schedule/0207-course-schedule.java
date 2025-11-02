class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph and indegree
       List<Integer>[] graph = new List[numCourses];
       int[] indegree = new int[numCourses];

       for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
       }

       for (int[] pre: prerequisites) {
            int start = pre[1], end = pre[0];
            graph[start].add(end);
            indegree[end]++;
       }

        // que: add course with 0 indegree
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) que.offer(i);
        }

        // bfs: keep reduce indegree and keeping adding couses with 0 indegree to queue
        int count = 0;
        while (!que.isEmpty()) {
            int curr = que.poll();
            count++;

            for (int next: graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) que.offer(next);
            }
        }

        return count == numCourses;
    }
}
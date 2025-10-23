class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int courseCount = 0;
        // 1. build graph and indegree
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite: prerequisites) {
            int start = prerequisite[1], end = prerequisite[0];
            graph[start].add(end);
            indegree[end]++;
        }

        // 2. add element with indegree of zero to que
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) que.offer(i);
        }

        // 3. bfs
        while (!que.isEmpty()) {
            int cur = que.poll();
            courseCount++;

            for (int course: graph[cur]) {
                indegree[course]--;
                if (indegree[course] == 0) que.offer(course);
            }
        }

        return courseCount == numCourses;
    }
}
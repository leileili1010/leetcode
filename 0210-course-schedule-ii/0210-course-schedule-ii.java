class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        // 0. edge case
        if (numCourses == 0) return new int[0];

        // 1. build graph and prerequisite
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite: prerequisites) {
            int start = prerequisite[1], end = prerequisite[0]; // start = 0, end = 1
            graph[start].add(end);
            indegrees[end]++;
        }

        // 2. bfs
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) que.offer(i);
        }

        int idx = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            res[idx++] = cur;

            for (int course: graph[cur]) {
                indegrees[course]--;
                if (indegrees[course] == 0) que.offer(course);
            } 
        }

        return idx == numCourses? res: new int[0];
    }
}
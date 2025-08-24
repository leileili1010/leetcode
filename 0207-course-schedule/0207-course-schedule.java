class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1 graph and indegree
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] course: prerequisites) {
            int start = course[1], end = course[0];
            graph[start].add(end);
            indegree[end]++;
        }

        // 2. find starter 
        Deque<Integer> que = new ArrayDeque<>(); 
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) que.offer(i);
        }

        // 3. BFS
        int selectedCourses = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            selectedCourses++;

            for (int course: graph[cur]) {
                indegree[course]--;
                if (indegree[course] == 0) que.offer(course);
            }
        }

        return selectedCourses == numCourses;
    }
}
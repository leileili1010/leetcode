class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        // build indegree
        // course with 0 indegree put in to queue, 

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

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i); 
        }

        int selectedCourses = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            selectedCourses++;

            for (int next: graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        return selectedCourses == numCourses;
    }


}
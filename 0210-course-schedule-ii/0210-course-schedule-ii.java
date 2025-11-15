class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph and indegree
        int[] res = new int[numCourses];
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

        // loop indegree and add elements with 0 indegree to que
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) que.offer(i);
        }

        // bfs
        int seletedCourses = 0;
        while (!que.isEmpty()) {
            int curr = que.poll();
            res[seletedCourses++] = curr;

            for (int next: graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) que.offer(next);
            } 
        }

        return seletedCourses == numCourses? res: new int[0];
    }
}
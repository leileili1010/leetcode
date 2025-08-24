class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 0. edge case
        if (numCourses == 0) return new int[0];

        // 1. graph and indegree
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] =  new ArrayList<>();
        }

        for (int[] course: prerequisites) {
            int start = course[1], end = course[0];
            graph[start].add(end);
            indegree[end]++;
        }

        // 2. find indegree = 0
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) que.offer(i);
        }

        // 3. que interative
        int selectedCourse = 0;
        int[] res = new int[numCourses];
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            res[selectedCourse++] = cur;
            for (int course: graph[cur]) {
                indegree[course]--;
                if (indegree[course] == 0) que.add(course);
            }
        }

        // return
        return selectedCourse == numCourses? res: new int[0];
    }
}
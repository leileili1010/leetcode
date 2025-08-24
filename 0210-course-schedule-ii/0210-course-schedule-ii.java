class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[1];
        
        // 构建graph & inDegree array
        List<Integer>[] graph = new ArrayList[numCourses]; // array of lists
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] courses: prerequisites) {
            graph[courses[1]].add(courses[0]);
            inDegree[courses[0]]++;
        }

        // 找出入度为0的放入que
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        }

        // Que循环
        int seletedCourses = 0; // 用于判断有没有上完所有课程
        int[] topoOrder = new int[numCourses];
        while (!que.isEmpty()) {
            int cur = que.poll();
            topoOrder[seletedCourses++] = cur; //上过的课就是indegree为0的课

            for (int course: graph[cur]) {
                inDegree[course]--;
                if (inDegree[course] == 0) {// inDeguree变为0的放入que
                    que.add(course);
                }
            }
        }

        return seletedCourses == numCourses? topoOrder: new int[0];
    }
}
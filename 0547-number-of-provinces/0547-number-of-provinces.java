class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        
        for (int city = 0; city < isConnected.length; city++) {
            if (!visited[city]) {
                res++;
                bfs(isConnected, city, visited);
            }
        }

        return res;
    }

    public void bfs(int[][] isConnected, int city, boolean[] visited ) {
        visited[city] = true;
        Deque<Integer> que = new ArrayDeque<>();
        que.add(city);
        
        while (!que.isEmpty()) {
            city = que.poll();
           
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[city][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }


}
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        int subIslandCount = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid2[i][j] == 1 && !visited[i][j]){
                    boolean isSubIsland = bfs(grid1,grid2,visited,i,j,n,m);
                    if(isSubIsland){
                        subIslandCount++;
                    }
                }
            }
        }

        return subIslandCount;
    }

    private boolean bfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j, int n, int m){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        visited[i][j] = true;

        boolean isSubIsland = true;

        if(grid1[i][j] != 1){
            isSubIsland = false;
        }

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int x = p.xCord;
            int y = p.yCord;

            for(int a=0; a<4; a++){
                int newX = x + dx[a];
                int newY = y + dy[a];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid2[newX][newY] == 1 && visited[newX][newY] == false){
                    if(grid1[newX][newY] != 1){
                        isSubIsland = false;
                    }
                    visited[newX][newY] = true;
                    queue.add(new Pair(newX,newY));
                }
            }
        }

        return isSubIsland;
    }
}

class Pair{
    int xCord;
    int yCord;
    public Pair(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }
}
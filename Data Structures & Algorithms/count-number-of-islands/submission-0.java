class Pair{
    int row;
    int col;
    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char ch = grid[i][j];
                if(ch == '1' && vis[i][j] == false) {
                    vis[i][j] = true;
                    queue.add(new Pair(i, j));
                    doBFS(vis, grid, queue, n, m);
                    count++;
                }
                else{
                    vis[i][j] = false;
                }
            }
        }
        return count;
    }

    private void doBFS(boolean[][] vis, char[][] grid, Queue<Pair> queue, int n, int m) {
        int[] drow = {0,-1,0,1};
        int[] dcol = {-1,0,1,0};
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == false && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}

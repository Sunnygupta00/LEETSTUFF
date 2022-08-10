class Solution {
    public int numIslands(char[][] grid) {
       int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n+1][m+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]=='1' && vis[i][j] == false){ // IF THERE IS LAND AND NOT VISITED YET
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char [][]adj, boolean vis[][], int i, int j){
        if(i<0 || j<0 || i>=adj.length || j>=adj[0].length || adj[i][j] == '0' || vis[i][j] == true){
            return;
        }
        vis[i][j] = true;
        dfs(adj, vis, i-1, j);
        dfs(adj, vis, i, j+1);
        dfs(adj, vis, i+1, j);
        dfs(adj, vis, i, j-1);
    }
    
}
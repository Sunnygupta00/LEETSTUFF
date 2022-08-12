class Solution {
    int n , m;
    public int maxAreaOfIsland(int[][] grid) {
        int area =0;
         n = grid.length; 
         m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    area = Math.max(dfs(grid, vis, i , j), area);
                }
            }
        }
        return area;
    }
    public int dfs(int [][]grid, boolean vis[][], int i, int j){
        if(i<0 || j<0 || j>=m || i>=n || grid[i][j] == 0 || vis[i][j] == true){
            return 0;
        }
        vis[i][j] = true;
        return dfs(grid, vis, i-1, j)+dfs(grid, vis, i+1, j)+dfs(grid, vis, i, j-1)+dfs(grid, vis, i, j+1)+1;
    }
   
}
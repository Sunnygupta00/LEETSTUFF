class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(i == 0 || j ==0 || i == n-1 || j == m-1 ){
                    if(grid[i][j] == 0){
                        dfs(grid, i, j);
                    }
                }
            }
        }
       /* for(int [] temp : grid){
            for(int p : temp){
                System.out.print(p+" ");
            }
            System.out.println();
        }
        */
        int count =0;
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                
                    if(grid[i][j] == 0){
                        dfs(grid, i, j);
                        count++;
                    }
                
            }
        }
       return count;
    }
    private int dir[][]={{-1,0},
                         {0, 1},
                         {1, 0},
                         {0, -1}
                        };
    
    public void dfs(int [][]adj, int i , int j){
        if(i<0 || i >= adj.length || j<0 || j >= adj[0].length || adj[i][j] == 1){
            return;
        }
        adj[i][j]= 1;
        for(int d[] : dir){
            dfs(adj, i+d[0], j+d[1]);
        }
    }
}
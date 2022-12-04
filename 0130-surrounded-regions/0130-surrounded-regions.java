class Solution {
    public void solve(char[][] board) {
        fill(board.length, board[0].length, board);
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n; i++){
             if(a[i][0] == 'O'&& vis[i][0] ==false ){
                    dfs(a, i, 0, n, m, vis);
                }  if(a[i][m-1] == 'O'&& vis[i][m-1]==false ){
                    dfs(a, i, m-1, n, m, vis);
                }
        }
         for(int i=0;i<m; i++){
             if(a[0][i] == 'O' && vis[0][i] ==false ){
                    dfs(a, 0, i, n, m, vis);
                }  if(a[n-1][i] == 'O'&& vis[n-1][i] ==false ){
                    dfs(a, n-1, i, n, m, vis);
                }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] ==false){
                     a[i][j] = 'X';
                }
            }
        }
    
        return a;
    }
    static private int dir[][] = {{1,0}, {-1,0},{0,1},{0,-1}};
    static void  dfs(char [][]a, int i, int j, int n, int m, boolean vis[][]){
        if(i<0 || j<0 || i>= n || j>=m || vis[i][j] == true ||  a[i][j]=='X'){
            return;
        } 
        vis[i][j] = true;
        for(int [] move : dir){
            int row = i+move[0];
            int col = j+ move[1];
            dfs(a, row, col, n, m, vis);
        }
        
    }
}
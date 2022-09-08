class Solution {
    public int uniquePaths(int m, int n) {
          int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]= -1;
            }
        }
        return rec(n-1, m-1, dp);
    }
    public int rec(int row, int col, int dp[][]  ){
        if(row<0 || col <0){
            return 0; 
        } 
        if(row == 0 && col ==0 ){
            return 1;
        }
        if(dp[row][col] != -1)return dp[row][col];
        int up = 0, left =0;
        up = rec(row-1, col, dp);
        left = rec(row, col-1,  dp);
        return dp[row][col]=up+left;
    }
}
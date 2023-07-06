//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
     public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int one = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    one++;
                }
            }
        }
        if(one == 0)return 0;
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        int time = 0;
        while(q.size()>0){
            time++;
            int size = q.size();
            for(int i=0;i<size;i++){
              int node []= q.poll();
                for(int move[] : dir ){
                    int row = node[0]+move[0];
                    int col = node[1]+move[1];
                    if(valid(grid, row, col, n, m)){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                    }
                }
            }
        }
        for(int i[] : grid){
            for(int j : i)if(j ==1)return -1;
        }
        
        return time-1; // hence in last we are not doing any work
        
    }
    public boolean valid(int grid[][], int i, int j, int n, int m){
        if(i<0 || j<0 || i >=n || j>=m || grid[i][j]==2 || grid[i][j] == 0){
            return false;
        }
        return true;
    }
       
}
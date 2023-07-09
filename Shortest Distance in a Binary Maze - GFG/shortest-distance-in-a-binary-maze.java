//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {

    int shortestPath(int[][] grid, int[] src, int[] destn) {
        
        if(grid[destn[0]][destn[1]] == 0)return -1;
        int n = grid.length;
        int m = grid[0].length;
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e8);
        }
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, src[0], src[1]));
        dist[src[0]][src[1]] = 0;
        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        
        while(q.size()>0){
            Pair temp = q.poll();
            int wt = temp.weight;
            int row = temp.row;
            int col = temp.col;
            if(row == destn[0] && col == destn[1]){
               return wt;
            }
            for(int move[] :dir){
                int r = row+move[0];
                int c = col+move[1];
                if(possible(grid,dist, r, c, n, m)){
                    int currWt = wt+1;
                    dist[r][c] = currWt;
                    q.offer(new Pair(currWt, r, c));
                }
            }
        }
        //   for(int i=0;i<n;i++){
        //         for(int j=0;j<m;j++){
        //             if(dist[i][j] == (int)1e8){
        //                 System.out.print("- ");
        //             }else{
        //                 System.out.print(dist[i][j]+" ");
        //             }
        //         }
        //         System.out.println();
        //     }
        return -1;
        
        
    }
    boolean possible(int grid[][], int dist[][],int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0 ||dist[i][j] != (int)1e8){
            return false;
        }
        return true;
    }
}
class Pair{
    int weight;
    int row;
    int col;
    Pair(int wt, int r, int c){
        weight = wt;
        row = r;
        col = c;
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
       int col[] = new int[n];
      return solve(0, graph, col, n, m);
    }
    public boolean solve(int node, boolean graph[][], int col[], int n, int m){
        if(node == n)return true;
        
        for(int i =1;i<=m;i++){
            if(possible(graph[node],  col, i, n)){
                col[node] = i;
                if(solve(node+1, graph, col, n, m))return true;
                col[node] = 0;
                
            }
        }
        return false;
    }
    public boolean possible(boolean graph[],int colour[],  int col, int n){
        for(int i=0;i<n;i++){
            if(graph[i] == true && colour[i] == col)return false;
        }
        return true;
    }
}
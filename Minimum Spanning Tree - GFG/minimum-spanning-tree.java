//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    private static int parent[];
    private static int rank[];
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Code Here.
	    Arrays.sort(edges, (a,b)->a[2]-b[2]);
	    parent = new int[V];
	    rank = new int[V];
	    for(int i=0;i<V;i++)parent[i] = i;
	    int weight = 0;
	    for(int i[] : edges){
	        int a = i[0];
	        int b = i[1];
	        int wt = i[2];
	        if(union(a,b) == true){
	            weight+=wt;
	        }
	    }
	    return weight;
	    
	}
	public static int findPar(int x){
	    if(x == parent[x])return x;
	    return parent[x] = findPar(parent[x]);
	}
	public static boolean union(int x, int y){
	    int xPar = findPar(x);
	    int yPar = findPar(y);
	    if(xPar == yPar)return false;
	    if(rank[yPar]> rank[xPar]){
	        parent[xPar] = yPar;
	    }else if(rank[yPar]<rank[xPar]){
	        parent[yPar] = xPar;
	    }else{
	        parent[yPar] = xPar;
	        rank[xPar]++;
	    }
	    return true;
	}
	
}
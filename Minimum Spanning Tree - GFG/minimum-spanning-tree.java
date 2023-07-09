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
	static int spanningTree(int V, int E, int edges[][]){
	    // created adj
	    List<List<Pair>>adj = new ArrayList<>();
	    for(int i=0;i<V;i++)adj.add(new ArrayList<>());
	    for(int i[] : edges){
	        int a = i[0];
	        int b = i[1];
	        int wt = i[2];
	        adj.get(a).add(new Pair(b, wt));
	        adj.get(b).add(new Pair(a,wt));
	    }
	    PriorityQueue<Pair>q = new PriorityQueue<>((a,b)-> a.wt-b.wt);
	       boolean vis[] = new boolean [V];
	       q.offer(new Pair(0,0));
	       int sum = 0;
	       while(q.size()>0){
	           Pair temp = q.poll();
	           int node = temp.node;
	           if(vis[node] == true) continue;
	           // if this node is vis  no need to add 
	           sum+= temp.wt;
	           vis[node] = true;
	           for(Pair i: adj.get(node)){
	               if(!vis[i.node]){
	                   q.offer(new Pair(i.node, i.wt));
	               }
	           }
	       }
	       return sum;
	}
	
}
class Pair{
    int wt, node;
    Pair(int x, int y){
        node = x;
        wt = y;
    }
}
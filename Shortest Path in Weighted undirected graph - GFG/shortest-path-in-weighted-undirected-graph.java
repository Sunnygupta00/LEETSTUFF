//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<Integer>ans = new LinkedList<>();
        // lets create adjacency list
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : edges){
            adj.get(i[0]).add(new Pair(i[1], i[2]));
            adj.get(i[1]).add(new Pair(i[0], i[2]));
        }
        int parent[] = dijkastra(adj, n);
        if(parent[n] == n){
            ans.add(-1);
            return ans;
        }
        int i = n;
        do{
           ans.add(0,i);
           i = parent[i];
        }while(i!=parent[i]);
        ans.add(0,1);
        return ans;
        
    }
    public static int []dijkastra(List<List<Pair>>adj, int v){
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        int dis[] = new int[v+1];
        Arrays.fill(dis, (int)1e8);
        q.offer(new Pair(1, 0));
        dis[1] = 0;
        int parent[] = new int[v+1];
        for(int i=0;i<v+1;i++)parent[i] = i;
        while(q.size()>0){
            Pair temp = q.poll();
            int node  = temp.node;
            int wt = temp.weight;
            for(Pair i : adj.get(node)){
                int currNode = i.node;
                int currWt = i.weight;
                if(dis[currNode]>currWt+dis[node]){
                    dis[currNode]=currWt+dis[node];
                    q.offer(new Pair(currNode, currWt));
                    parent[currNode] = node;
                }
            }
        }
        for(int i=0;i<v+1;i++){
           // System.out.println(i+"->"+parent[i]);
        }
        
        return parent;
        
        
    }
}
class Pair{
    int node, weight;
    Pair(int x, int y){
        node = x;
        weight = y;
    }
}
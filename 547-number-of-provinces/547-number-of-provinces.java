class Solution {
    public int findCircleNum(int[][] isConnected) {
        
       int n = isConnected.length;
        int count = 0;
        boolean vis[] = new boolean[n+1];
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                dfs(isConnected, vis, i, n);
                count++;
            }
        }
        return count;
    }
    public void dfs(int [][]adj, boolean vis[],int source,int n){
        vis[source] = true;
       for(int i = 0;i<n; i++){
           if(adj[source][i] == 1 && vis[i] == false){
               dfs(adj,vis,i,n);
           }
       }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
     if(connections.length < n-1)return -1;   // MINIMUM EDGE
        List<Integer> adj[] = new List[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        boolean vis[] = new boolean[n];
        for(int []c : connections){
            adj[c[0]].add(c[1]);
            adj[c[1]].add(c[0]);
        }
        int count = 0;
       for(int i =0; i<n; i++){
           if(vis[i] == false){
               dfs(adj, vis, i);
              count++;
           }
       }
        return count-1;
    }
    public void dfs(List<Integer>adj[], boolean []vis, int source){
        if(vis[source] == true){
            return ;
        }
        vis[source] = true;
        for( int u : adj[source]){
            dfs(adj, vis, u);
        }
    }
}
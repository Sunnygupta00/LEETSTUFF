class Solution {
    public int makeConnected(int n, int[][] com) {
        if(com.length < n-1){
            return -1;
        }
      List<Integer> adj[] = new List [n];
        for(int i=0;i<n;i++){
            adj[i]= new LinkedList<>();
        }
        for(int c[] : com){
            adj[c[0]].add(c[1]);
            adj[c[1]].add(c[0]);
        }
        boolean vis[] = new boolean[n];
        int count =0;
        for(int i = 0; i<n; i++ ){
            if(vis[i]== false){
                dfs(adj, vis, i);
                count++;
            }
        }
        return count-1;
        
    }
    public void dfs(List<Integer> adj[], boolean vis[], int source){
        if(vis[source]== true){
            return;
        }
        // add to ans
        vis[source]= true;
        for(int i : adj[source]){
            dfs(adj, vis, i);
        }
    }
}
class Solution {
    boolean ans ;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
    
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int c[] : edges){
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
        }
       ans = false;
        boolean vis[]= new boolean[n];
        dfs(adj,vis, source,destination);
        return ans;
    }
    public void dfs( List<List<Integer>>adj, boolean vis[], int source, int destination ){
        if(vis[source]== true || ans == true){
            return;
        }
        if(source == destination){
            ans = true;
        }
        vis[source] = true;
        for(int i: adj.get(source)){
            dfs(adj, vis, i, destination);
        }
    }
    
}
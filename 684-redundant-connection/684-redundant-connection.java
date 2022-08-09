class Solution {
    private int a=0,b=0;
    public int[] findRedundantConnection(int[][] edges) {
        if(edges.length == 0)return new int[]{0,0};
        // LETS CREATE GRAPH
        int n = edges.length+1;
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i<n; i++ ){
            adj.add(new ArrayList<>());
        }
        boolean vis[] = new boolean[n];
        int ans []= new int[2];
        for(int c[]: edges){
            Arrays.fill(vis, false);
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
            if(dfs(adj, vis, c[0], -1)){
                return c; // hence this is our extra edge
            }
        }
        return ans;
    }
    public boolean dfs(List<List<Integer>> adj, boolean vis[],int source, int parent){
        if(vis[source]== true)return true;
        vis[source] = true;
        for(int i: adj.get(source)){
          if(parent != i && dfs(adj, vis, i, source)){
              return true;
          }
        }
        
     return false;
    }
    
    
}
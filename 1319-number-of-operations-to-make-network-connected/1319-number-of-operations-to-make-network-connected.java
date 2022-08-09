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
               bfs(adj, vis, i);
              count++;
           }
       }
        return count-1;
    }
    public void bfs(List<Integer>adj[], boolean []vis, int source){
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        while(q.size()>0){
            int curr = q.poll();
            for(int i : adj[curr]){
                if(vis[i] == false){
                    q.offer(i);
                    vis[i] = true;
                }
            }
        }
    }
}
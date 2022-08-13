class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
       for(int i =0;i<n;i++){
           if(color[i]==-1){
               if(bfs(graph, i, color) == false){
                   return false;
               }
           }
       }  
        return true;
        
    }
    public boolean bfs(int[][] graph, int node, int color[]){
         Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node]=0;
        while(q.size()>0){
            int index = q.poll();
            //System.out.println(index+" "+col);
            for(int  i: graph[index]){
               // System.out.println(i);
                if(color[i]==-1){
                    color[i]= color[index] == 0 ? 1 : 0;
                    q.offer(i);
                }else{
                    if(color[i] == color[index]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

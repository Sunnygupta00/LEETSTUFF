class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
       for(int i =0;i<n;i++){
           if(color[i]==-1){
               if(dfs(graph, i , color) == false){
                   return false;
               }
           }
       }  
        for(int i: color){
            System.out.print(i+" ");
        }
        return true;
        
    }
   public boolean dfs(int [][]graph, int node, int color[]){
       if(color[node] == -1){
           color[node] =1;
       }
       for(int i: graph[node]){
           if(color[i] == -1){
               color[i] = 1-color[node];
               if(dfs(graph, i, color) == false){
                   return false;
               }
           }else{
               if(color[i] == color[node]){
                   return false;
               }
           }
       }
       return true;
   }
}

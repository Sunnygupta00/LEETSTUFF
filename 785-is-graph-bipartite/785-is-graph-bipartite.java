class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
       for(int i =0;i<n;i++){
           if(color[i]==-1){
               if(dfs(graph, i ,1, color) == false){
                   return false;
               }
           }
       }  
       
        return true;
        
    }
   public boolean dfs(int [][]graph, int node, int col ,int color[]){
       if(color[node] != -1){
           return color[node] == col;
       }
       color[node] = col;
       for(int i: graph[node]){
           if(dfs(graph, i, 1-color[node], color) == false){
               return false;
           }
       }
       return true;
   }
}

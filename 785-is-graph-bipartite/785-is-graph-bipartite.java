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
         Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node,0));
        color[node]=0;
        while(q.size()>0){
             Pair curr = q.poll();
            int index = curr.i;
            int col = curr.color;
            //System.out.println(index+" "+col);
            for(int  i: graph[index]){
               // System.out.println(i);
                if(color[i]==-1){
                    color[i]= col == 0 ? 1 : 0;
                    q.offer(new Pair(i,color[i]));
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
class Pair{
    int i;
    int color;
    Pair(int x,int y){
        i=x;
        color=y;
    }
}
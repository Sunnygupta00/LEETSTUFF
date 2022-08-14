class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        int n= prerequisites.length;
         int indegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int c[] : prerequisites){
            adj.get(c[1]).add(c[0]);
            
        }
       // CALCULATING INDEGREE
        for(int i =0;i<numCourses;i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count =0;
        while(q.size()>0){
            int curr = q.poll();
          //  System.out.println(curr);
            count++;
            for(int i: adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        return count==numCourses;
        
    }
}
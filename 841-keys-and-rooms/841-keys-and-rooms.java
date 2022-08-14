class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean [n];
        dfs(rooms, vis, 0);
        for(boolean i : vis){
            if(i==false){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>>rooms, boolean []vis, int source){
        if(vis[source]==true){
            return;
        }
        vis[source] = true;
        for(int i : rooms.get(source)){
            dfs(rooms,vis,i);
        }
    }
}
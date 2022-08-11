class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        int n = graph.length;
        dfs(graph,ans, curr, 0, n-1);
        return ans;
    }
    public void dfs(int graph[][], List<List<Integer>> ans , List<Integer>curr, int source, int destination){
        if(source == destination){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i : graph[source]){
            curr.add(i);
            dfs(graph, ans, curr, i, destination);
            curr.remove(curr.size()-1);
        }
    }
}
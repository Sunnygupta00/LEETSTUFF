class Solution {
    private int n, m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         n = image.length;
         m = image[0].length;
        
        boolean vis[][] = new boolean[n][m];
        dfs(image, vis, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void dfs(int [][]adj, boolean [][]vis, int i, int j , int color, int same){
        if(i<0 || i>= n || j<0 || j>=m || vis[i][j] == true || adj[i][j]!=same){
            return;
        }
        vis[i][j] =true;
        adj[i][j] = color;
        dfs(adj, vis, i-1, j, color, same);
        dfs(adj, vis, i, j+1, color, same);
        dfs(adj, vis, i+1, j, color, same);
        dfs(adj, vis, i, j-1, color, same);
    }
}
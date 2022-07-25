
class Solution {
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        int K[] = new int [1];
        K[0]= k;
        rec(root, K);
        return ans;
    }
    public void rec(TreeNode root, int k[]){
        if(root == null)return ;
        rec(root.left,k);
        k[0]--;
        if(k[0] == 0){
            ans = root.val;
            return;
        }
        rec(root.right,k);
    }
}
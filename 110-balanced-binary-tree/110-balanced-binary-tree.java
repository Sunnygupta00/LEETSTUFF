
class Solution {
    int height;
    public boolean isBalanced(TreeNode root) {
        height=0;
       rec(root);
        return height<=1;
    }
    public int rec(TreeNode root){
        if(root==null)return 0;
        int left=rec(root.left);
        int right=rec(root.right);
        height=Math.max(Math.abs(left-right),height);
        return Math.max(left,right)+1;
    }
}
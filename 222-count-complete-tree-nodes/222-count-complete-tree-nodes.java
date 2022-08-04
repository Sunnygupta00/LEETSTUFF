
class Solution {
    private int count = 0;
    public int countNodes(TreeNode root) {
        rec(root);
        return count;
    }
    public void rec(TreeNode root){
        if(root == null)return;
        count++;
        rec(root.left);
        rec(root.right);
    }
}
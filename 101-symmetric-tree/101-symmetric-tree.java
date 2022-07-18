
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return same(root.left, root.right);         
    }
    public boolean same(TreeNode left,TreeNode right){
        if(left==null || right==null)return left==right;
        return left.val==right.val && same(left.left,right.right) && same( left.right,right.left);
    }
}
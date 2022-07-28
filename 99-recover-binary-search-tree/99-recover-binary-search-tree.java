
class Solution {
    private TreeNode prev = null;
    private TreeNode first = null, second = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev ;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
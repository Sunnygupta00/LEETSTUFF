
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        prev=first=second=null;
        rec(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void rec(TreeNode root){
        if(root == null )return;
        rec(root.left);
        if(prev!=null && prev.val > root.val){
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        rec(root.right);
    }
}
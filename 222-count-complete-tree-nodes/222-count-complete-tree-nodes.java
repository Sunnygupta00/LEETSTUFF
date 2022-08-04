
class Solution {
   
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
       int left = leftHeight(root.left);
        int right = rightHeight(root.right);
        if(left == right)return (2<<(left))-1;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int leftHeight(TreeNode root){
        if(root == null)return 0;
        int h =0;
        TreeNode curr = root;
        while(curr != null){
            h++;
            curr = curr.left;
        }
        return h;
    }
     public int rightHeight(TreeNode root){
        if(root == null)return 0;
        int h =0;
        TreeNode curr = root;
        while(curr != null){
            h++;
            curr = curr.right;
        }
        return h;
    }
}
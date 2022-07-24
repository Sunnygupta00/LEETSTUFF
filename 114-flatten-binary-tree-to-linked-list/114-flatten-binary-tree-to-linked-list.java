
class Solution {
   // USING MORRIS TRAVERSAL
    public void flatten(TreeNode root) {
        if(root == null)return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
              TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right; // CREATING NEW LINK
                curr.right = curr.left; 
                curr.left =null;         // BREAKING THE LINK
            }
            curr = curr.right;
        }
    }
}
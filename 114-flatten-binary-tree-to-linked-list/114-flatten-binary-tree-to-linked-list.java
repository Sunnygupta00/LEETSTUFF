
class Solution {
   
    public void flatten(TreeNode root) {
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size()>0){
            TreeNode temp = stack.pop();
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(stack.size()>0) temp.right = stack.peek();
            temp.left = null;
        }
    }
}
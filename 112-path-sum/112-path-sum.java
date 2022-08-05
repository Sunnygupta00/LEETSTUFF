
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {  
        if(root == null)return false;
        boolean check = root.left == null && root.right == null && targetSum-root.val == 0 ? true : false;
        boolean left = hasPathSum(root.left,targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return check || left || right;
    }
}
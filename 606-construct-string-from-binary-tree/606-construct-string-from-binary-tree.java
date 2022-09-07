/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private String ans =""; 
    public String tree2str(TreeNode root) {
        if(root ==null)return "";
         
        return rec(root, new StringBuilder());
       
    }
    public String rec(TreeNode root, StringBuilder sb){
        if(root == null)return "";
        String val = root.val+"";
        String left = rec(root.left, sb);
        String right = rec(root.right,sb);
        if(left == "" && right == "")return val;
        if(left == "" && right != "")return val+"()("+right+")";
        if(left != "" && right == "")return val+"("+left+")";
        return val+"("+left+")"+"("+right+")";
         
    }
}
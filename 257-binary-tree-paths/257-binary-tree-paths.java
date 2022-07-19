
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ans =new ArrayList<>();
        rec(root,"",ans);
        return ans;
    }
    public void rec(TreeNode root, String temp, List<String> ans){
        if(root.right==null && root.left == null){
            ans.add(temp+root.val);
            return;
        }
          if(root.right!=null) rec(root.right, temp+root.val+"->", ans);
        if(root.left!=null) rec(root.left, temp+root.val+"->", ans);
    }
}
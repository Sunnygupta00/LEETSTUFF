
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer>ans=new ArrayList<>();
        rec(root, ans);
        return ans;
    }
    public void rec ( TreeNode root, List<Integer>ans){
        if(root==null)return ;
        rec(root.left, ans);
        ans.add(root.val);
        rec(root.right, ans);
        
    }
}
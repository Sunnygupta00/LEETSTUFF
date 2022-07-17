
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer>ans=new ArrayList<>();
        rec(root,ans,0);
        return ans;
    }
    public void rec(TreeNode root, List<Integer>ans, int count){
        if(root==null){
            return;
        }
        if(count==ans.size())ans.add(root.val);
        rec(root.right, ans, count+1);
        rec(root.left, ans, count+1);
        
    }
}
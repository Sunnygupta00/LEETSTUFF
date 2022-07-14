
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer>ans=new ArrayList<>();   
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(root!=null || stack.size()>0){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                TreeNode temp= stack.pop();
                ans.add(temp.val);
                root=temp.right;
            }
        }
        return ans;
        
    }
}
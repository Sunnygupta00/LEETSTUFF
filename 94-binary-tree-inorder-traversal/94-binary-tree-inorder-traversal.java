
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer>ans=new ArrayList<>();
        
        Stack<TreeNode>stack = new Stack<>();
        TreeNode curr=root;
       while(true){
           if(curr!=null){
               stack.add(curr);
               curr=curr.left;
           }else{
               if(stack.size()==0)break;
               TreeNode temp= stack.pop();
               ans.add(temp.val);
               curr=temp.right;
           }
           
       }
        return ans;
        
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if(root==null)return res;
        Stack<TreeNode>stack=new Stack<>();
        while(root!=null || stack.size()>0){
            if(root!=null){
                stack.add(root);
                root=root.left;
            }else{
                TreeNode temp=stack.peek().right;
                if(temp==null){
                    temp=stack.pop();
                    res.add(temp.val);
                    while(stack.size()>0 && temp==stack.peek().right){
                        temp=stack.pop();
                        res.add(temp.val);
                    }
                }else{
                    root=temp;   // add all its left element
                }
            }
        }
        return res;
        
    }
  
}

       
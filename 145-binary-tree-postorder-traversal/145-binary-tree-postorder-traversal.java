
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if(root==null)return res;
        Stack<TreeNode>one=new Stack<>();
        Stack<TreeNode>two=new Stack<>();
        one.add(root);
        while(one.size()!=0){
            TreeNode temp=one.pop();
            two.add(temp);
            if(temp.left!=null){
                one.push(temp.left);
            }if(temp.right!=null){
                one.push(temp.right);
            }
        }
        while(two.size()!=0){
            res.add(two.pop().val);
        }
        return res;
    }
  
}

       
class Solution {
    public int kthSmallest(TreeNode p, int k) {
      Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = p;
        while(stack.size()>0 || curr!=null){
            if(curr != null){
                stack.push(curr);
                curr= curr.left;
            }else{
                k--;
                TreeNode temp = stack.pop();
                if(k==0)return temp.val;
                 curr = temp.right;
            }
        }
        return -1;
}
}
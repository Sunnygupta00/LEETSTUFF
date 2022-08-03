
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null)return ans;
       Stack<TreeNode>stack = new Stack<>();
        TreeNode curr = root;
        while(stack.size()>0 || curr!=null){
            if(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp != null){
                    curr = temp;
                }else{
                    temp = stack.pop();
                    ans.add(temp.val);
                    while(stack.size()>0 && stack.peek().right == temp){
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                }
                
            }
        }
        return ans;
    }
}
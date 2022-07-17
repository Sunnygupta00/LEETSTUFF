
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null || stack.size()>0){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;                      //1. LEFT
            }else{
                TreeNode temp = stack.peek().right;
                if(temp==null){
                    temp = stack.pop();
                    ans.add(temp.val);                        // ROOT
                    while(stack.size()>0 && temp==stack.peek().right){
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                }else{// discover right side
                    curr=temp;                        // 2. THEN RIGHT
                }
            }
        }
        return ans;
        
    }
}
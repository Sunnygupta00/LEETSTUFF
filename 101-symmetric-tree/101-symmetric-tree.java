
class Solution {
    public boolean isSymmetric(TreeNode root) {
      if(root==null)return true;
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(q.size()>0){
           int size = q.size();
            for(int i=0;i<size/2;i++){
                TreeNode left =q.poll();
                TreeNode right= q.poll();
                if(left==null && right==null)continue;
                if(left==null || right ==null)return false;
                if(left.val != right.val)return false;
                q.offer(left.left);          // QUESTION IS WHY WE ARE ADDING NULL VALUES, BECASE VALUES CAN BE ALWAYS SAME, BUT ALIGNMENT NOT 
                q.offer(right.right);
                q.offer(left.right);
                q.offer(right.left);
            }
        }
        return true;
    }
}
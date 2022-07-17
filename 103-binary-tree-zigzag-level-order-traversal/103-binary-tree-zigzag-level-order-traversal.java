
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new LinkedList<>();
        if(root==null) return ans;
       Queue<TreeNode>q=new LinkedList<>();
        boolean flag=false;
        q.offer(root);
        while(q.size()>0)
        {
            List<Integer>level=new ArrayList<>();
             int size=q.size();
            for(int i=0;i<size;i++)
            { 
                TreeNode curr=q.poll();
                if(flag)
                {
                    level.add(0,curr.val);
                }
                else{
                    level.add(curr.val);
                }
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
               
            }
            ans.add(level);
            flag=!flag;
        }
        return ans;
    }
}
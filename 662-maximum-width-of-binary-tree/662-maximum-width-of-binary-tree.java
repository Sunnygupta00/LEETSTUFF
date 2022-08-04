
class Pair{
    TreeNode node;
    int id;
    Pair(TreeNode n,int i)
    {
        node=n;
        id=i;    
    }
}
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
    if(root==null)return 0;
        int ans=0;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(q.size()>0)
        {
            int size=q.size();
            int start=0,last=0;
            int min=q.peek().id;
            for(int i=0;i<size;i++)
            {
                Pair temp=q.poll();
                TreeNode curr=temp.node;
                int curr_id=temp.id-min;
                if(i==0)start=curr_id;
                if(i==size-1)last=curr_id;
                if(curr.left!=null)q.offer(new Pair(curr.left,curr_id*2+1));
                if(curr.right!=null)q.offer(new Pair(curr.right,curr_id*2+2));
                ans=Math.max(ans,last-start+1);
            }
            
        }
        return ans;
    }

}
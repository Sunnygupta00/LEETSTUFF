
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        int count =0;
        Map<TreeNode, TreeNode>parent = new HashMap<>();
         fill(root,parent);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode>hs = new HashSet<>();
        q.offer(target);
        hs.add(target);
        while(q.size()>0){
            if(count == k)break;
            count++;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
            if(curr.left != null && !hs.contains(curr.left)){
                q.offer(curr.left);
                hs.add(curr.left);
            }if(curr.right != null && !hs.contains(curr.right)){
                q.offer(curr.right);
                hs.add(curr.right);
            }if(parent.get(curr) != null && !hs.contains(parent.get(curr))){
                q.offer(parent.get(curr));
                hs.add(parent.get(curr));
            }
            }
        }
        while(q.size()>0){
            ans.add(q.poll().val);
        }
        return ans;
    }
    
    public void fill(TreeNode root, Map<TreeNode,TreeNode>parent){
        Queue<TreeNode> q = new LinkedList<>();
        //  Map<TreeNode,TreeNode>parent = new HashMap<>();
        q.offer(root);
        while(q.size()>0){
            TreeNode temp = q.poll();
            if(temp.left != null){
                parent.put(temp.left, temp);
                q.offer(temp.left);
            }if(temp.right != null){
                parent.put(temp.right, temp);
                q.offer(temp.right);
            }
        }
        
    }
}
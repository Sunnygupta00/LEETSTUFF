/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         
         Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        q.offer(root);
        while(q.size()>0){
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                curr.add(temp.val);
                for(Node tt : temp.children){
                    q.offer(tt);
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}
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
    public List<Integer> preorder(Node root) {
      
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();
          if(root == null)return ans;
        while(stack.size()>0){
            Node temp = stack.pop();
           if(temp != null) ans.add(temp.val);
            Stack<Node> rev = new Stack<>();
            for(Node i : temp.children){
                rev.push(i);
            }
            while(rev.size()>0){
                stack.push(rev.pop());
            }
        }
        return ans;
    }
}

class Solution {
    private int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
          return construct(preorder,Integer.MAX_VALUE);
    }
    public TreeNode construct(int [] pre, int bound){
        if(i == pre.length || bound < pre[i]){
            return null;
        }
        TreeNode root = new TreeNode(pre[i++]);
        root.left = construct(pre, root.val);
        root.right = construct (pre, bound);
        return root;
    }
}
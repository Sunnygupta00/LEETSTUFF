class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length)return null;
        int length=preorder.length-1;
        return build(preorder, 0, length, inorder, 0, length);
    }
    public TreeNode build( int pre[], int preStart, int preEnd, int in[], int inStart, int inEnd){
        if(inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode (pre[preStart]);
        int index = inStart;
        for(; index<= inEnd; index++){
            if(root.val == in[index]){
                break;
            }
        }
        int leftSize = index - inStart;
        int rightSize = inEnd - index;
        root.left = build( pre, preStart+1, preStart+1+leftSize-1, in, inStart, index-1);
        root.right = build( pre, preStart+leftSize+1, preEnd, in, index+1, inEnd);
            return root;
    }
}
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length)return null;
        int length = inorder.length-1;
        return build(inorder, 0, length, postorder, 0, length);
    }
    public TreeNode build(int in[],int inStart, int inEnd, int post[], int posStart, int posEnd){
        if(inStart>inEnd )return null;
        TreeNode root = new TreeNode(post[posEnd]); // create root
        int index = inStart;
        for(; index<=inEnd; index++){
            if(root.val == in[index]){
                break;
            }
        }
        int leftTree = index-inStart;
        int rightTree = inEnd-index;
        root.left = build(in, inStart, index-1, post, posStart, posStart+leftTree-1);
        root.right = build(in, index+1, inEnd, post, posEnd-rightTree, posEnd-1);
        
        return root;
    }
}
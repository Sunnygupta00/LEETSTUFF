class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        if(pre.length != in.length)return null;
        int length = in.length-1;
        return build(in, 0, length, pre, 0, length);
    }
    public TreeNode build(int in[], int inStart, int inEnd, int pre[], int preStart, int preEnd){
        if(inStart>inEnd)return null;
        TreeNode root = new TreeNode (pre[preStart]);
        int index = inStart;
        for(;index<= inEnd; index++){
            if(root.val == in[index])break;
        }
        int leftSize = index - inStart;
        int rightSize = inEnd - index;
        root.left = build(in, inStart, index-1, pre, preStart+1, preStart+leftSize);
        root.right = build(in ,index+1, inEnd, pre, preStart+leftSize+1, preEnd);
        return root;
    }
}
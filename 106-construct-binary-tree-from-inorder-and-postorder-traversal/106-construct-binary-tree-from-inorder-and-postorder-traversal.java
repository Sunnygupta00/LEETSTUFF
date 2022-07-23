
class Solution {
    public TreeNode buildTree(int[] in, int[] post) {
        if(in.length != post.length )return null;
        int length = in.length-1;
        return build(in, 0, length, post, 0, length);
    }
    public TreeNode build(int []in, int inStart, int inEnd, int post[], int postStart, int postEnd){
        if(inStart>inEnd)return null;
        TreeNode root = new TreeNode (post[postEnd]);
        int index = inStart;
        for(; index<= inEnd; index++){
            if(in[index] == root.val){
                break;
            }
        }
        int leftSize = index-inStart;
        int rightSize = inEnd-index;
        root.left = build (in, inStart, index-1, post, postStart, postStart+leftSize-1);
        root.right = build (in, index+1, inEnd, post, postStart+leftSize, postEnd-1);
        return root;
    }
}
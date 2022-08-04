
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
    if(root==null)return root;
    if(key>root.val){
        root.right=deleteNode(root.right,key);
    }else if(key<root.val){
        root.left=deleteNode(root.left,key);
    }else{
        if(root.right==null){
            return root.left;
        }else if(root.left==null){
            return root.right;
        }
        TreeNode minv=findMin(root.right);
        minv.left = root.left;
        return root.right;
    }
        return root;
    }
    public TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
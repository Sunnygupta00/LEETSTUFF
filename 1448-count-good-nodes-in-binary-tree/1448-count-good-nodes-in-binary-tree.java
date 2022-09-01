
class Solution {
    private int count = 0; 
    public int goodNodes(TreeNode root) {
        rec(root, Integer.MIN_VALUE);
        return count;
    }
    public void rec(TreeNode root, int bound ){
        if(root == null)return;
        int curr = root.val;
        if(curr >= bound){
           // System.out.print
            count++;
        }
        rec(root.left, Math.max(bound, curr));
        rec(root.right, Math.max(bound, curr));
    }
}
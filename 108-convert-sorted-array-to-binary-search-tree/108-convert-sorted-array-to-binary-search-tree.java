
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       if(nums.length == 0)return null;
        return rec(nums, 0, nums.length-1);
    }
    public TreeNode rec(int []nums, int start, int end){
        if(start>end)return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = rec(nums,start, mid-1);
        root.right = rec(nums,mid+1, end);
        return root;
    }
}
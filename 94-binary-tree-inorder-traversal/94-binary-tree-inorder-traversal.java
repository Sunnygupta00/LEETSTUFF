
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right; // BHAI LEFT NULL HAI RIGHT SIDE DEKH lo
            }else{
                TreeNode prev = curr.left; // left ke baad root pr ane ka jugad
                while(prev.right !=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null) { // malab hamne connection nahi banaya
                    prev.right = curr;
                    curr = curr.left ;// now go for next left 
                }else{      // means mera connection bana hua hai, means i have visited left side, so break the connection and go right
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
                
            }
        }
        return ans;
    }
}
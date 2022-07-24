public class Codec {

    public String serialize(TreeNode root) {
        if(root==null)return "";
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(q.size()>0){
            TreeNode temp = q.poll();
            if(temp==null){
                sb.append("N ");
                continue;
            }
            sb.append(temp.val+" ");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        System.out.println(sb);
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        String [] values = data.split(" ");
        TreeNode root = new TreeNode (Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
        for(int i=1; i<values.length ;i++){
            TreeNode temp = q.poll();
            if(!values[i].equals("N")){           // ADDING IN LEFT
                temp.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(temp.left);
            }
            i++;
            if(!values[i].equals("N")){            // ADDING IN RIGHT
                temp.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(temp.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
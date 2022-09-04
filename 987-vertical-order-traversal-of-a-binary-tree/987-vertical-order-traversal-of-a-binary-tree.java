
class Tuple {
    TreeNode node; 
    int row;
    int col; 
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node; 
        row = _row; 
        col = _col; 
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(q.size()>0){
            Tuple temp = q.poll();
             TreeNode curr = temp.node;
            int row = temp.row;
            int col = temp.col;
            if(!map.containsKey(row)){
                map.put(row, new TreeMap<>());
            }if(!map.get(row).containsKey(col)){
                map.get(row).put(col, new PriorityQueue<>());
            }map.get(row).get(col).add(curr.val);
            if(curr.left!=null)q.offer(new Tuple(curr.left, row-1, col+1));
            if(curr.right!=null)q.offer(new Tuple(curr.right, row+1, col+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> i: map.values()){
           List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq : i.values()){
                 
                while(pq.size()>0){
                    
                    temp.add(pq.poll());
                }
               
            } ans.add(temp);
        }
        return ans;
    }
}
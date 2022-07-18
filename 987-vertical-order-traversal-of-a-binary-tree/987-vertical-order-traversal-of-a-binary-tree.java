class Tuple{
    TreeNode node;
    int v;
    int h;
    Tuple(TreeNode root, int ver, int hig){
        node=root;
        v=ver;
        h=hig;
    }
    
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
          Map<Integer, Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
          Queue<Tuple>q = new LinkedList<>();
          q.offer(new Tuple(root,0,0));// root/ver/h
          while(q.size()>0){
              Tuple temp = q.poll();
              TreeNode curr = temp.node;
              int ver= temp.v;
              int h = temp.h;
              if(!map.containsKey(ver)){
                  map.put(ver,new TreeMap<>());
              }if(!map.get(ver).containsKey(h)){
                  map.get(ver).put(h,new PriorityQueue<>());
              }
              map.get(ver).get(h).add(curr.val);
              if(curr.left!=null)q.offer(new Tuple(curr.left,ver-1,h+1));
              if(curr.right!=null)q.offer(new Tuple(curr.right,ver+1,h+1));
          }
        List<List<Integer>>ans = new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer> >i : map.values()){
            List<Integer>temp = new ArrayList<>();
            for(PriorityQueue<Integer> j : i.values()){
                while(j.size()>0){
                    temp.add(j.poll());
                }
            }
            ans.add(temp);
        }
        return ans; 
    }
}
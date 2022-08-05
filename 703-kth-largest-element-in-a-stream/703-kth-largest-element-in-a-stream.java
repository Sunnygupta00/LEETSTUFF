class KthLargest {
      private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int p;
    public KthLargest(int k, int[] nums) {
        p=k;
       for(int i: nums ){
           pq.add(i);
       }
    }
    
    public int add(int val) {
       pq.add(val);
        while(pq.size()>p){
            pq.poll();
        }
        return pq.peek();
    }
}


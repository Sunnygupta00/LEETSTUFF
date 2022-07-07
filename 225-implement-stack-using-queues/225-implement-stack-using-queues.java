class MyStack {
  Queue<Integer> q1 =new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
      q1.offer(x);
      for(int i=0;i<q1.size()-1;i++){
          q1.offer(q1.poll());           // removing all element after x such that mera x peek ban jaye;
      }
        
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
       return q1.peek();    
    }
    
    public boolean empty() {
       return q1.size()==0;    
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
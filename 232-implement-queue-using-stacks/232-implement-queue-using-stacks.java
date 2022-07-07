class MyQueue {
   Stack<Integer>one=new Stack<>();
    Stack<Integer>two=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(one.size()>0){
            two.push(one.pop()); /// FIRST TRANSFERING ALL ELEMENT IN TWO
        }
        two.push(x);          
        while(two.size()>0){
            one.push(two.pop()); // transfer again to make element as last inserted element 
        }
    
    }
    
    public int pop() {
      return one.pop();    
    }
    
    public int peek() {
     return one.peek();    
    }
    
    public boolean empty() {
      return one.size()==0;    
    }
}


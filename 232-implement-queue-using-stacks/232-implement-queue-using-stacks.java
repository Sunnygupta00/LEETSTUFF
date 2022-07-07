class MyQueue {
   Stack<Integer>input=new Stack<>();
   Stack<Integer>output=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
       if(output.size()>0){
           return output.pop();
       }else{
           while(input.size()>0){
               output.push(input.pop());
           }
           return output.pop();           
       }    
    }
    
    public int peek() {
      if(output.size()>0){
           return output.peek();
       }else{
           while(input.size()>0){
               output.push(input.pop());
           }
           return output.peek();           
       }        
    }
    
    public boolean empty() {
      return input.size()==0 && output.size()==0;    
    }
}


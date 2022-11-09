class StockSpanner {
      Stack<Pair> stack = new Stack<>();
    private int x =0;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int res =1;
        while(stack.size()>0 && stack.peek().val<=price){
           res+=stack.pop().i;
        }
       stack.push(new Pair(price,res));
        return res;  
        
        
    }
}
class Pair{
    int val;
    int i;
    Pair(int x, int y){
        val = x;
        i =y;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class Solution {
    public String makeGood(String s) {
    
     StringBuilder sb = new StringBuilder();        
        Stack<Character> stack = new Stack<>();
       for(char temp : s.toCharArray()){
            if(stack.size()>0 && check(stack.peek(), temp)){
               stack.pop();
           }
          else stack.push(temp);
       }
         
        while(stack.size()>0)sb.append(stack.pop());
        return sb.reverse().toString();
       
    }
    static boolean check (char a , char b){
        return Character.toLowerCase(a) == Character.toLowerCase(b) && a !=b;
    }
}
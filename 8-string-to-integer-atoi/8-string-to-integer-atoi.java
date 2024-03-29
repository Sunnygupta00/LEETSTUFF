class Solution {
    public int myAtoi(String s) {
       int n=s.length();
        int i=0;
        int ans=0,sign=1;
        while(i<n && s.charAt(i)==' ')i++;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i)=='-') ?-1 : 1;
            i++;
        }
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
          int num=s.charAt(i)-'0';
          if(ans > Integer.MAX_VALUE /10 || (ans==Integer.MAX_VALUE/10 && num>7)){
              return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
          } 
           ans=ans*10+num;
            i++;
        }
        return ans*sign;
        
    }
}
class Solution {
    public String longestPalindrome(String s) {
       int n=s.length();
       char []arr=s.toCharArray();
       int start=0;
        int end=1;// intially size will be one;
       for(int i=1;i<n;i++){  // SINCE I HAVE TO TAKE TWO POINTER
           // IF EVEN STRING
           int low=i-1;
           int high=i;
           while(low>=0 && high<n && arr[low]==arr[high]){
               // if current length is greater
               if(high-low+1>end){
                 start=low;
                 end=high-low+1;
               }
               low--;
               high++;
           }
           
           // IF ODD STRING
            low=i;// of
            high=i;
           while(low>=0 && high<n && arr[low]==arr[high]){
                // if current length is greater
               if(high-low+1>end){
                 start=low;
                 end=high-low+1;
               }
               low--;
               high++;
           }
          
       }
        return s.substring(start,start+end); 
    }
    
}

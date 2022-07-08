class Solution {
    public String longestPalindrome(String s) {
     int n=s.length();
        int low;
        int high;
        char arr[]=s.toCharArray();
        int start=0;
        int end=1;
        for(int i=1;i<n;i++){
            // FOR ODDSUBSTRING
            low=i-1;
             high=i+1;
            while(low>=0 && high<n && arr[low]==arr[high]){
                if(high-low+1>end){
                start=low;
                end=high-low+1;
               }
                low--;
                high++;
            }
            // FOR EVENSUBSTRING
            low=i-1;
             high=i;
            while(low>=0 && high<n && arr[low]==arr[high]){
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

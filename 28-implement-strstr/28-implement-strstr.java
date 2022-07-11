class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length())return -1;
     return rabin(haystack,needle);   
    }
    
      public int rabin(String txt, String pat){
        int n=txt.length();
        int m=pat.length();
        int prime=101;
        int pow=1;
        int maxChar=256;
        // calculating power 
        for(int i=0; i<m-1; i++){
            pow=(pow*maxChar)%prime;
        }
        int patHash=0;
        int textHash=0;
        // Calculating pat and text(first m ) Hash
        for(int i=0; i<m; i++){
            patHash= (maxChar*patHash + pat.charAt(i))%prime;
            textHash= (maxChar*textHash + txt.charAt(i))%prime;
        }
        // now searching int n-m window;
        for(int i=0; i<n-m+1; i++){
            int j;
            if(patHash==textHash){
                boolean check=true;
                // checking 
                for( j=0; j<m; j++ ){
                    if(txt.charAt(i+j)!=pat.charAt(j)){
                        check=false;
                        break;
                    }
                }
                if(m==j)return i;
            }
            if(i<n-m){// if it is less than last window index;
                
                textHash=   (maxChar*(textHash-pow*txt.charAt(i)) + txt.charAt(i+m)) %prime;
                if(textHash<0)textHash+=prime;
                       
            }
        }
        return -1; // if not found;
    }
}
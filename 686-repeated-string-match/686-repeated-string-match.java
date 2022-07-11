class Solution {
    public int repeatedStringMatch(String a, String b) {
      // BRUTE FORCE
        for(int i=0; i<a.length(); i++){
            int j;
            for(j=0; j<b.length() && a.charAt((i+j)%a.length())==b.charAt(j);j++);
            if(j==b.length())return (j+i-1)/a.length()+1;
        }
        return -1;
        
        
    }
}
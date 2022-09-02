class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = s.length();
        if(n!=m)return false;
        int []one = new int[256];
        int [] two = new int[256];
        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(one[a]!=two[b]){
                return false;
            }
            one[a] = i+1;
            two[b] = i+1;
            
            
        }
        return true;
        
    }
}
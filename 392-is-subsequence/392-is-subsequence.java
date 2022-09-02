class Solution {
    public boolean isSubsequence(String s, String t) {
        int one = s.length();
        int two = t.length();
        int i =0;
        int j =0;
        while(i<one && j<two){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==one;
        
    }
}
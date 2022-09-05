class Solution {
    public int longestPalindrome(String s) {
      HashSet<Character> hs = new HashSet<>();
        int count = 0;
        
        for(char c : s.toCharArray()){
            if(hs.contains(c)){
                count++;
                hs.remove(c);
            }else{
                hs.add(c);
            }
        }
        if(hs.size()>0)return count*2+1;
        
        return count*2;
        
    }
}
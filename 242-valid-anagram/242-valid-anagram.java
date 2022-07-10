class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int []character = new int[256];
        for(int i=0;i<s.length();i++){
            character[s.charAt(i)]++;
            character[t.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(character[i]!=0)return false;
        }
        return true;
        
    }
}
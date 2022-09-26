class Solution {
    private int parent[] = new int[26];
    public int findPar(int x){
        if(parent[x] == x)return x;
        return parent[x] = findPar(parent[x]);
    }
    public boolean equationsPossible(String[] equations) {
     
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        for(String s: equations){
            char a = s.charAt(0);
            char b = s.charAt(3);
            char c = s.charAt(1);
            if(c == '='){
                parent[findPar(a-'a')] = findPar(b-'a'); 
            }
        }
        for(String s : equations){
            char a = s.charAt(0);
            char b = s.charAt(3);
            char c = s.charAt(1);
            if(c == '!' && (findPar(a-'a') == findPar(b-'a'))){
                return false;
            }
        }
        return true;
    }
}
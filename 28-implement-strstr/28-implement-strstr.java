class Solution {
    public int strStr(String txt, String pat) {
        if(txt.length()<pat.length())return -1;
        return rabinAlgo(txt.toCharArray(),pat.toCharArray());
    }
    public int rabinAlgo(char txt[], char pat[]){
        int n=txt.length;
        int m=pat.length;
        int patHash=0,txtHash=0;
        int prime=101;
        int pow=1;
        int totalChar=256;
        for(int i=0;i<m-1;i++)pow=(pow*totalChar)%prime;
        // hash for txt and pattern;
        for(int i=0;i<m;i++){
            patHash= (totalChar*patHash + pat[i])%prime;
            txtHash = (totalChar* txtHash+ txt[i])%prime;
        }
        for(int i=0;i<=n-m;i++){
            if(patHash==txtHash){
                boolean check=true;
                for(int j=0;j<m;j++){
                    if(pat[j]!=txt[i+j]){
                        check=false;
                        break;
                    }
                }
                if(check)return i;
            }
            if(i<n-m){
                txtHash= (totalChar*(txtHash-pow*txt[i])+txt[i+m])%prime;
                if(txtHash<0){
                    txtHash+=prime;
                }
            }
        }
        return -1;
    }
    
}
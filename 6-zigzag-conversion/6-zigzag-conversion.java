class Solution {
    public String convert(String s, int numRows) {
       StringBuilder sb []=new StringBuilder[numRows];
        char arr[]=s.toCharArray();
        for(int i=0;i<numRows;i++){
            sb[i]=new StringBuilder();
        }
        int i=0;int n=s.length();
        while(i<n){
            for(int ind=0;ind<numRows && i<n ;ind++){// INSERTING FIRST N ELEMENTS
                sb[ind].append(arr[i++]);
            }
            for(int ind=numRows-2;ind>0 && i<n; ind--){
                sb[ind].append(arr[i++]); // INSERTING OTHER ELEMENT IN DIGONAL FORM
            }
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder t: sb){
            //System.out.println(t);
            ans.append(t);
        }
        return ans.toString();
    }
}
/*
I LIKE THIS TRICK INCREASE COUNTER TILL N-1 AND THEN DECREASE WHAT IS ESPECIAL?
EX i=0 , d=1;
   i+=d;
   if(i==n-1 || i==0)d=-d;
   this way we can easily do zigzagtraversal
*/
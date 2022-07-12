// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer>ans=new ArrayList<>();
        int n=txt.length();
        int m=pat.length();
        int lps[]=new int[m];
        for(int i=1;i<m;i++){
            int j=lps[i-1];
            while(j>0 && pat.charAt(j)!=pat.charAt(i)){
                j=lps[j-1];
            }
            if(pat.charAt(j)==pat.charAt(i)){
                j++;
            }
            lps[i]=j;
        }
        int i=0,j=0;
        while(i<n){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }else{ // IF NOT MATCHING
                 
                if(j>0){
                     j=lps[j-1];
                }else{
                    i++;
                }
            }
            if(j==m){
                ans.add(i-m+1);
                j=lps[j-1];
            }
        }
        return ans;
    }
    
}
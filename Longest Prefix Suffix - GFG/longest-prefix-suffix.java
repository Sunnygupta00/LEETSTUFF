// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        char arr[]=s.toCharArray();
        int []lps=new int[s.length()];
        int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[j]){
                lps[i]=++j;
            }else if(j>0){
                j=lps[j-1];
                i--;
            }
        }
        return j;
    }
}
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
        int i=1;
        int max=Integer.MIN_VALUE;
        while(i<arr.length){
            int j=lps[i-1];
            while(j>0 && arr[i]!=arr[j]){
                j=lps[j-1];
            }
            if(arr[i]==arr[j]){
                j++;
            }
            max=Math.max(max,j);
            lps[i++]=j;
        }
        return lps[arr.length-1];
    }
}
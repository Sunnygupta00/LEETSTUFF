//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        // code here
        Set<Integer>hs = new TreeSet<>();
        for(int div = 2; div*div <=N ;div++){
            while(N%div == 0){
                N/=div;
                hs.add(div);
            }
        }
        if(N != 1){
            hs.add(N);
        }
        
        int ans[] = new int[hs.size()];
        
       int i =0;
        for(int ptr: hs){
            ans[i++] = ptr;
        }
        return ans;
    }
}
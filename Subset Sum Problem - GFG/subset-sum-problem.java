//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        int dp[][] = new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(n-1, arr, sum,dp)>0;
    }
    static int rec(int n, int arr[], int sum, int dp[][]){
        if(n<0 || sum <=0){
            if(sum == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[n][sum]!=-1){
            return dp[n][sum];
        }
         int pick = rec(n-1, arr, sum-arr[n], dp);
          int notPick = rec(n-1, arr, sum, dp);
          return dp[n][sum]=Math.max(pick, notPick);
    }
}
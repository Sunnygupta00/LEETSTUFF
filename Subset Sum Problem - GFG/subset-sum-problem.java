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
        return subsetSumToK(n, sum, arr);
    }
     public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k+1];
         for(int i=0;i<n;i++){
             dp[i][0] = true;
         }
         if(arr[0]<= k){
             dp[0][arr[0]] = true;
         }
         for(int i=1;i<n;i++){
             for(int j=1;j<=k;j++){
                 boolean pick = false;
                 if(j-arr[i]>=0){
                     pick = dp[i-1][j-arr[i]];
                 }
                 boolean notPick = dp[i-1][j];
                 dp[i][j] = pick | notPick;
             }
         }
         return dp[n-1][k];
       }
        public static int rec(int n, int k, int arr[], int dp[][]){
        if(n<0 || k<=0 ){
            if(k == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[n][k] != -1)return dp[n][k];
        return dp[n][k]=rec(n-1, k, arr, dp)+ rec(n-1, k-arr[n], arr,dp);
    }
}
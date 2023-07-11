//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int dp[] = new int[n+1];
        for(int i =1;i<=n;i++){
             int one = arr[i-1]+(i>1?dp[i-2]: 0);
             int two = Integer.MIN_VALUE;
            if(i>1){
                two = arr[i-2]+(i>2 ?dp[i-3]: 0);
            }
            dp[i] = Math.max(one, two);
        }
        return dp[n];
    }
    public int rec(int arr[], int n, int dp[]){
        if(n<=0)return 0;
        if(dp[n] != -1)return dp[n];
        int one = arr[n-1]+rec(arr, n-2, dp);
        int two = Integer.MIN_VALUE;
        if(n>1){
            two = arr[n-2]+rec(arr, n-3, dp);
        }
        return dp[n] = Math.max(one, two);
    }
}
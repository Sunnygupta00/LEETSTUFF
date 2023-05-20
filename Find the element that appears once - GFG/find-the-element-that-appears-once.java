//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int n)
    {
        int start = 0;
        int end = n-1;
       while(start<end){
           int mid = start+(end-start)/2;
           if(arr[mid] != arr[mid^1]){
               end = mid;
           }else if(arr[mid] == arr[mid^1]){
               start = mid+1;
           }
       }
       return arr[start];
    }
}
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr,0,  (int)N-1);
    }
    static long mergeSort(long arr[], int start, int end){
        long count = 0;
        if(start< end){
            int mid = start+(end-start)/2;
            count+= mergeSort(arr, start, mid);
            count+= mergeSort(arr, mid+1, end);
            count+= merge(arr, start, mid, end);
        }
        return count;
    }
    static long merge(long arr[], int start, int mid, int end){
        int n = mid-start+1;
        int m = end-mid-1+1;
        long count = 0;
        long left[] = new long[n];
        long right[] = new long[m];
        for(int i=0;i<n;i++){
            left[i] = arr[start+i];
        }
        for(int i = 0;i<m; i++){
            right[i] = arr[i+mid+1];
        }
        int i = 0, j = 0, k = start;
        while(i<n && j<m){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }else{
                count+= n-i;
                arr[k++] = right[j++];
            }
        }
        while(i<n){
            arr[k++] = left[i++];
        }
        while(j<m){
            arr[k++] = right[j++];
        }
        return count;
    }
    
}
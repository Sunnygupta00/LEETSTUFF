//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int length = n+m;
        int gap = length/2+(length%2);
        while(gap !=0){
            int left = 0;
            int right = left+gap;
            while(right<length){
                
                if(left<n && right>=n){
                    swapIfNeed(arr1, arr2, left, right-n);
                }else if(left >=n ){
                    swapIfNeed(arr2, arr2, left-n, right-n);
                }else {
                    swapIfNeed(arr1, arr1,left, right);
                }
                left++;
                right++;
            }
            if(gap == 1)break;
            
            gap = (gap)/2 + gap%2;
        }
        
       
    }
    public static void swapIfNeed(long arr[], long arr2[], int i, int j){
         if(arr[i]>arr2[j]){
             long temp = arr[i];
             arr[i] = arr2[j];
             arr2[j] = temp;
         }
    }
}

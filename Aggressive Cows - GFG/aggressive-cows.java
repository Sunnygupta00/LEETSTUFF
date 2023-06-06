//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start =1 ;
        int end = (int)1e9;
        int res = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(valid(stalls, mid, k)){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }
    public static boolean valid(int arr[], int dif, int total){
        int first = 0;
        int count = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-arr[first] >= dif){
                first = i;
                count++;
            }
            if(count>=total)return true;
        }
        return false;
    }
}
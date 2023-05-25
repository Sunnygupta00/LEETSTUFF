//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        List<Integer> ans = new ArrayList<>();
        int index = -1;
        // finding dip
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(arr, 0, n-1);
            addAll(ans, arr);
            return ans;
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[index]){
                swap(arr, i, index);
                break;
            }
        }
        reverse(arr, index+1, n-1);
        addAll(ans, arr);
        return ans;
        
    }
    static void addAll(List<Integer> ans, int arr[]){
        for(int i: arr){
            ans.add(i);
        }
        
    }
    static void reverse(int arr[], int start, int end){
        while(start<end){
            swap(arr, start++, end--);
        }
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        rec(arr, n, ans,  0);
        return ans;
        
    }
    void rec(ArrayList<Integer> arr, int n, ArrayList<Integer> ans, int sum ){
      if(n <= 0){
          ans.add(sum);
          return;
      }   
      rec(arr, n-1, ans, sum+arr.get(n-1)); // pick 
      rec(arr, n-1, ans, sum); // not pick
    }
}
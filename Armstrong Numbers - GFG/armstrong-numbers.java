//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
      int arr[] = new int[3];
      int i = 0;
      int temp = n;
      while(n!=0){
          arr[i++] = n%10;
          n/=10;
      }
      if(((arr[0]*arr[0]*arr[0])+ (arr[1]*arr[1]*arr[1])+(arr[2]*arr[2]*arr[2])) == temp ){
          return "Yes";
      }
      return "No";
    }
}
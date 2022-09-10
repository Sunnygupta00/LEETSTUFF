class Solution {
   public int maxProfit(int k, int[] prices) {
       int n = prices.length;
       int[][] tp = new int[k+1][n+1];
       for(int[] arr : tp) Arrays.fill(arr, -1);
       return solve(k,n,prices,tp);
   }
   
   public int solve(int k, int n, int[] arr, int[][] tp){
       if(k==0 || n==0) return 0; // if any of then becomes 0, no profit
       if(tp[k][n]!=-1) return tp[k][n];
       int curr = arr[n-1], profit = 0;
   	
   	// Finding max profit for current day. As we are moving backwards, if we sell on day let say p, and purchase it on q (where q<p) then the next possible transaction would be from day q. That's why we use function solve() again while getting our profit. Also as we have transacted once, we reduce the value of k. 
       for(int i=n-1;i>=0;i--) profit = Integer.max(profit, (curr-arr[i]) + solve(k-1,i,arr,tp));
       
   	// if we decide not to transact on that day, we simply reduce n, else go with our 'profit'.
   	return tp[k][n] = Integer.max(solve(k,n-1,arr,tp), profit);
   }
}
//TABULATION
class Solution {
    public int climbStairs(int n) {
        if(n ==1 || n==2)return n;
          int dp[] = new int [n+1];
          Arrays.fill(dp, -1);
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]; // sum of last two stair combinaton
        }
        return dp[n];
    }
}
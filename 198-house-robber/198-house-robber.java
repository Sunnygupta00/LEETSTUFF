class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
     int dp[] = new int[n]; 
        Arrays.fill(dp, -1);
        return rec(n-1, nums, dp);
    }
    public int rec(int i, int nums[], int dp[]){
        if(i == 0)return nums[0]; // mainly for not Pick 
        if(i <0 )return 0;   // mainly for pick
        if(dp[i] != -1)return dp[i];
        int pick = nums[i]+ rec(i-2, nums, dp);
        int notPick = 0+ rec(i-1, nums, dp);
        return dp[i] =  Math.max(pick , notPick);
    }
}
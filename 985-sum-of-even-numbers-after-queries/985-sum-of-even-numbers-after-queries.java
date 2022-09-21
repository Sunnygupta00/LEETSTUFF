class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
       int sum =0;
        int p =0; 
        int t = queries.length;
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i: nums){
            if(Math.abs(i) % 2== 0)sum+=i;
        }
        for(int i =0; i<t; i++){
            int val = queries[i][0];
            int index = queries[i][1];
            if(Math.abs(nums[index]) % 2 == 0){
                sum -= nums[index];
            }
               nums[index] += val;
              if(Math.abs(nums[index])% 2 == 0){
                 sum+= nums[index];
               }
            ans[p++] = sum;
        }
        return ans;
        
    }
}
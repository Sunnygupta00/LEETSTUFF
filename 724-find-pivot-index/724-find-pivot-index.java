class Solution {
    public int pivotIndex(int[] nums) {
        int n= nums.length;
        int left [] = new int [n];
        left [0] = nums[0];
        for(int i=1;i<n;i++){
            left[i] = nums[i]+left[i-1];
        }
        int right[] = new int[n];
        right[n-1] = nums[n-1];
        for(int i = n-2;i>=0 ;i--){
            right[i] = nums[i]+right[i+1];
        }
        for(int i=0;i<n;i++){
            left[i]-=right[i];
            if(left[i]==0){
                return i;
            }
        }
        return -1;
    }
}
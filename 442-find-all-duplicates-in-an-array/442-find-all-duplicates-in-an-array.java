class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n+1];
        List<Integer> ans  = new ArrayList<>();
        for(int i=0;i<n;i++){
            int val = nums[i];
            freq[val]++;
        }
        for(int val =0; val <n+1; val++){
            if(freq[val] == 2){
                ans.add(val);
            }
        }
        return ans;     
        
        
    }
}
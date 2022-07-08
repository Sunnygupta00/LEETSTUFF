class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String>ans=new ArrayList<>();
        HashSet<Integer>hs=new HashSet<>();
        int max=0;
        for(int i:target){
            hs.add(i);max=Math.max(max,i);
        }
        for(int i=0;i<max;i++){
            ans.add("Push");
            if(!hs.contains(i+1)){
                ans.add("Pop");
            }
        }
        return ans;
        
    }
}
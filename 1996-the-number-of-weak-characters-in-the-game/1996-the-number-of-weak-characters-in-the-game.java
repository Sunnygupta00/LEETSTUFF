class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Stack<int[]> stack = new Stack<>();
        int count =0;
        Arrays.sort(properties, (a,b) -> (a[0] == b[0])? a[1]-b[1] : b[0]- a[0]);
        int max = 0;
        for(int i=0;i<properties.length;i++){
            if(properties[i][1]<max){
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }
}

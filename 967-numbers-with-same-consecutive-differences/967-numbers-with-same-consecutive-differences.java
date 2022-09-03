class Solution {
     public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(N, K, i, ans);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    private void dfs(int n, int K, int num, List<Integer> ans) {
        if (n == 1) {
            ans.add(num);
        }else {
            int digit1 = num % 10 - K, digit2 = num % 10 + K;
            if (digit1 >= 0) {
                dfs(n - 1, K, num * 10 + digit1, ans);
            }
            if (digit2 != digit1 && digit2 < 10) {
                dfs(n - 1, K, num * 10 + digit2, ans);
            }
        }
    }
        
}
    
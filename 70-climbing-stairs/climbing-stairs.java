class Solution {
    public int solve(int ind, int[] dp){
        if(ind == 0) return 1;
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];
        int step1 = solve(ind-1, dp);
        int step2 = solve(ind-2, dp);

        return dp[ind] = step1 + step2;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
       return solve(n, dp);
    }
}
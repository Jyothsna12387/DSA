class Solution {
    public int solve(int ind, int[] nums, int[] dp){
        //base case
        if(ind == 0) return nums[0];
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int skip = 0 + solve(ind-1, nums, dp);
        int take = nums[ind] + solve(ind-2, nums, dp);

        return dp[ind] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n-1, nums, dp);
    }
}
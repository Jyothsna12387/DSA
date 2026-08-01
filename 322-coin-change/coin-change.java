class Solution {
    public int solve(int ind, int amount, int[] coins, int[][] dp){
        //base case
        if(amount == 0) return 0;
        if(ind == 0){
            return amount % coins[0] == 0 ? amount/coins[0] : (int)1e9;
        }
        
        if(dp[ind][amount] != -1) return dp[ind][amount];

        //try all possibilities
        int skip = solve(ind-1, amount, coins, dp);
        int take = (int) 1e9;
        if(coins[ind] <= amount){
            take = 1+solve(ind, amount-coins[ind], coins, dp);
        }
        dp[ind][amount] = Math.min(take,skip);
        return  dp[ind][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = solve(n-1, amount, coins,dp);
        if (ans >= (int) 1e9) return -1;
        else return ans;
    }
}
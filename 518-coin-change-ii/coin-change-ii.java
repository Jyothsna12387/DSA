class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        // Base case: 1 way to make amount 0 (using no coins)
        dp[0] = 1;
        
        // Iterate over each coin first to ensure unique combinations (no permutations)
        for (int coin : coins) {
            for (int target = coin; target <= amount; target++) {
                dp[target] = dp[target] + dp[target - coin];  //skip+take
            }
        }
        
        return dp[amount];
    }
}
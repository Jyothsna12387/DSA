class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        
        // Base case: 1 way to make amount 0 (using no coins)
        dp[0] = 1;
        
        for(int target=1; target<=amount; target++){
            dp[target] = (target % coins[0] == 0) ? 1 : 0;
        }

        // Iterate over each coin first to ensure unique combinations (no permutations)
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= amount; target++) {
                int notTake = dp[target];
                int take = 0;
                if (coins[ind] <= target) {
                    take = dp[target - coins[ind]];
                }
                dp[target] = take + notTake;
            }
        }
        return dp[amount];
    }
}
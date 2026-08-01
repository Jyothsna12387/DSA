class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        
        //base case(amount == 0)
            dp[0] = 0;
        
        //base case 2(index == 0 which means fill first row)
        for(int target=1; target<=amount; target++){
            dp[target] = target % coins[0] == 0 ? target/coins[0] : (int)1e9;
        }

        // Fill the remaining table
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= amount; target++) {
                int notTake = dp[target];
                int take = (int) 1e9;

                if (coins[ind] <= target) {
                    take = 1 + dp[target - coins[ind]];
                }
                dp[target] = Math.min(take, notTake);
            }
        }
        int ans = dp[amount];
        return ans >= (int) 1e9 ? -1 : ans;
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        //base case(amount == 0)
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }
        //base case 2(index == 0 which means fill first row)
        for(int target=1; target<=amount; target++){
            dp[0][target] = target % coins[0] == 0 ? target/coins[0] : (int)1e9;
        }

        // Fill the remaining table
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= amount; target++) {
                int notTake = dp[ind - 1][target];
                int take = (int) 1e9;

                if (coins[ind] <= target) {
                    take = 1 + dp[ind][target - coins[ind]];
                }
                dp[ind][target] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return ans >= (int) 1e9 ? -1 : ans;
    }
}
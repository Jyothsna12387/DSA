class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        
        //base case(amount == 0)
            dp[0] = 1;
        
        //base case 2(index == 0 which means fill first row)
        for(int target=1; target<=amount; target++){
            dp[target] = target % coins[0] == 0 ? 1 : 0;
        }

        // Fill the remaining table
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= amount; target++) {
                int notTake = dp[target];
                int take = 0;

                if (coins[ind] <= target) {
                    take = dp[target - coins[ind]];
                }
                dp[target] = take+notTake;
            }
        }
        int ans = dp[amount];
        return ans;
    }
}
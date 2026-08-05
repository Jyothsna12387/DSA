class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
  
        //base case
        dp[0] = nums[0];

        for(int i=1; i<n; i++){
            int skip = dp[i-1];
            // int take = nums[i] + dp[i-2];
            int take = nums[i];
            if(i > 1){
                take += dp[i-2];
            }
            dp[i] = Math.max(take, skip);
        }
        return dp[n-1];
    }
}
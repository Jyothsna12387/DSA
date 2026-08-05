class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int skip = prev1;
            // int take = nums[i] + dp[i-2];
            int take = nums[i];
            if(i > 1){
                take += prev2;
            }
            int curr = Math.max(take, skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
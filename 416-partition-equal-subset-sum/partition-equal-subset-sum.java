class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int x : nums){
            totalsum += x;
        }
        if(totalsum % 2 != 0) return false;
        int target = totalsum / 2;

        boolean[][] dp = new boolean[n][target+1];

        //base case 1(target is 0)
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        //base case 2
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        //fill dp table
        for(int ind=1; ind<n; ind++){
            for(int t=1; t<=target; t++){
                boolean skip = dp[ind-1][t];
                boolean take = false;
                if(nums[ind] <= t){
                  take = dp[ind-1][t-nums[ind]];
                }
                dp[ind][t] = take || skip;
            }
        }
        return dp[n-1][target];
    }
}
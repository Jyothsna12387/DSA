class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int x : nums){
            totalsum += x;
        }
        if(totalsum % 2 != 0) return false;
        int target = totalsum / 2;

        boolean[] dp = new boolean[target+1];

        //base case 1(target is 0)
         dp[0] = true;

        //base case 2
        if(nums[0] <= target){
            dp[nums[0]] = true;
        }

        //fill dp table
        for(int ind=1; ind<n; ind++){
            for(int t=target; t>=nums[ind]; t--){
                dp[t] = dp[t] || dp[t-nums[ind]];
            }
        }
        return dp[target];
    }
}
class Solution {
    public boolean solve(int ind, int target, int[] nums, int[][] dp){
        //base cases
        if(target == 0) return true;
        if(ind == 0) return nums[0] == target; //single element left

        if(dp[ind][target] != -1) 
            return dp[ind][target] == 1;

        //try all possibilities
        boolean skip = solve(ind-1, target, nums, dp);
        boolean take = false;

        if(nums[ind] <= target){
            take = solve(ind-1, target-nums[ind], nums, dp);
        }
        dp[ind][target] = (take || skip) ? 1 : 0;
        return take || skip;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int x : nums){
            totalsum += x;
        }

        if(totalsum % 2 != 0) return false;
        int target = totalsum / 2;

        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(n-1,target,nums,dp);
    }
}
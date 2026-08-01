class Solution {
    public int solve(int ind, int target, int[] nums){
        //base case
        if(ind == 0){
            if(target == 0 && nums[0] == 0) return 2;  //element taking=1, empty set(not picking)=1,  total=2 ways
            else if(target == 0) return 1;   //element skipping(empty subset) = 1 way
            else if (nums[0] == target) return 1;
            else return 0;
        }

        int skip = solve(ind-1, target, nums);
        int take = 0;
        if(nums[ind] <= target){
            take = solve(ind-1, target-nums[ind], nums);
        }
        return skip + take;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalsum = 0;
        for(int num : nums){
            totalsum += num;
        }
        int s2 = (totalsum + target)/2;

        // Impossible cases
        if (totalsum + target < 0 || (totalsum + target) % 2 != 0) {
            return 0;
        }

        return solve(n-1, s2, nums);
    }
}
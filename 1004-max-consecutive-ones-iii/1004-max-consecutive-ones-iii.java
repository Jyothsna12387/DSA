class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerocount = 0;
        int maxcount = 0;
        int currmax = 0;

        int left=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right] == 0){
                zerocount++;
            }

            while(zerocount > k){
                if(nums[left] == 0){
                    zerocount--;
                }
                left++;
            }
            currmax = Math.max(0, right-left+1);
            maxcount = Math.max(maxcount,currmax);

        }
        return maxcount;
    }
}
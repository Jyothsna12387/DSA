class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg = 0;
        double sum = 0;

        //calculate First window sum
        for(int i=0; i<k; i++){
            sum = sum+nums[i];
        }
        maxavg = sum/k;

        //Slide the window
        for(int i=k; i<nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            maxavg = Math.max(maxavg, sum/k);
        }

        return maxavg;
    }
}
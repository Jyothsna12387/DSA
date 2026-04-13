class Solution {
    public int pivotIndex(int[] nums) {
        int leftsum = 0;
        int totalsum = 0;
        //calculate total sum
        for(int num : nums){
            totalsum += num;
        }
        for(int i=0; i<nums.length; i++){

            if(2*leftsum + nums[i] ==  totalsum){
                return i;
            }
            else{
                leftsum += nums[i];
            }
        }
        return -1;
    }
}
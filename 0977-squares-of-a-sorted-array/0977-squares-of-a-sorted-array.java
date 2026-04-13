class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int n=nums.length;
        int left=0; int right=n-1; int k=n-1;
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[k]=nums[left]*nums[left];
                left++;
            }
            else{
                result[k]=nums[right]*nums[right];
                right--;
            }
            k--;
            }
            return result;
    }
}
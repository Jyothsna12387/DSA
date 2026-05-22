class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target)  return mid;
            else if(nums[mid] >= nums[left]){   //left sorted array
                if(target >= nums[left] && target < nums[mid]){
                    right -= 1;
                }
                else{
                    left += 1;
                }
            }
            else {     //right sorted array
                if(target > nums[mid] && target <= nums[right]){
                    left += 1;
                }
                else{
                    right -= 1;
                }
            }
        }
        return -1;
    }
}
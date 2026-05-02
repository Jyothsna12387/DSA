class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int[] nums, int k){
        int count = 0;
        int left = 0;
        int[] freq = new int[nums.length+1];
        int distinctCount = 0;

        for(int right=0; right<nums.length; right++){
            int val = nums[right];
            if(freq[val] == 0){
                distinctCount++;
            }
            freq[val]++;
            

            while(distinctCount > k){
                freq[nums[left]]--;

                if(freq[nums[left]] == 0){
                    distinctCount--;
                }
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0, candidate = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
                count++;
            }
            else if(num == candidate){
                count++;
            }
            else{
                count--;     
            }
        }

        //verification step
        int freq = 0;
        for(int num : nums){
            if(num == candidate){
                freq++;
            }
        }
        if(freq > n/2){
            return candidate;
        }
        else{
            return -1;
        }
    }
}
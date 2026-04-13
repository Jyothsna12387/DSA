class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int neededSum = target - nums[i];

            if(map.containsKey(neededSum)){
                return new int[]{map.get(neededSum), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
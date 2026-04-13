class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0 ; int prefixsum=0;
        map.put(0,1);
        for(int num : nums){
            prefixsum = prefixsum + num;

            if(map.containsKey(prefixsum-goal)){
                count += map.get(prefixsum-goal);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}
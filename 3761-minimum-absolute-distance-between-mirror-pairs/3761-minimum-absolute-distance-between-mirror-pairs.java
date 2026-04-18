class Solution {
    public int reverse(int n){
        int res = 0;
        while(n > 0){
            res = res * 10 + (n % 10);
            n = n/10;
        }
        return res;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int min_dis = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            // check if current number matches any previous reversed
            if(map.containsKey(nums[i])){
                min_dis = Math.min(min_dis, i - map.get(nums[i]));
            }

            // store reverse for future matches
            map.put(reverse(nums[i]), i);
        }
       return min_dis == Integer.MAX_VALUE ? -1 : min_dis;
    }
}
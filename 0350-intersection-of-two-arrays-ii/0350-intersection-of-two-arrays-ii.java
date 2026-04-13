class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new java.util.HashMap<>();
        
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        //store nums1 elements and its frequency in map
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        //traverse nums2 and store the common elements in resultList
        List<Integer> resultList = new java.util.ArrayList<>();

        for(int num : nums2){
            if(map.containsKey(num) && map.get(num)>0){
                resultList.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        //convert list to array and return
        int[] result = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
            System.out.print(result[i] + " ");
        }
        return result;
    }
}
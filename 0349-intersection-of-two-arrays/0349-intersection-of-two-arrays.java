class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        List<Integer> resultSet = new java.util.ArrayList<>();

        if(nums1.length>nums2.length){
            return intersection(nums2, nums1); // Ensure smaller array is stored into hashSet for space optimization
        }
        for(int num : nums1){    // Add elements of nums1 to the set
            set.add(num);
        }
        for(int num : nums2){
            if(set.contains(num)){
                resultSet.add(num); // Add common elements to the result list
                set.remove(num); // Remove the element from the set to avoid duplicates in the result
            }
        }
        int[] result = new int[resultSet.size()];
        for(int i=0;i<resultSet.size();i++){
            result[i] = resultSet.get(i);
        }
        return result;
    }
}
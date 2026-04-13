class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int highestaltitude = 0;

        for(int num : gain){
            sum += num;
            highestaltitude = Math.max(highestaltitude, sum);
        }
        return highestaltitude;
    }
}
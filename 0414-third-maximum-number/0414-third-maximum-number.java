class Solution {
    public int thirdMax(int[] nums) {
        long firstMax=Long.MIN_VALUE;
        long secondMax=Long.MIN_VALUE;
        long thirdMax=Long.MIN_VALUE;
        for(int n: nums){
            if(n>firstMax){
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=n;
            }
            else if(n>secondMax && n!=firstMax){
                thirdMax=secondMax;
                secondMax=n;
            }
            else if(n>thirdMax && n!=secondMax && n!=firstMax){
                thirdMax=n;
            }
        }
        if(thirdMax==Long.MIN_VALUE){
            return (int)(firstMax);
        }
        return (int)(thirdMax);
    }
}

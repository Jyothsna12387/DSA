class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int ind=n-1; ind>=0; ind--){
            if(num.charAt(ind) % 2 != 0){
                return num.substring(0, ind+1);
            }
        }
        return "";
    }
}
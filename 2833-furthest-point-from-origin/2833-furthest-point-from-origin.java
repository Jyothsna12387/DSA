class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0,  countR = 0,  countU = 0;
        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i);

            if(ch == 'L')  countL++;
            else if(ch == 'R')  countR++;
            else  countU++;
        }
        return Math.abs(countL-countR)+countU;
    }
}
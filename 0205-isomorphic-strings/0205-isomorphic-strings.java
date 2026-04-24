class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[256];
        int[] mapTS = new int[256];
        int n =s.length();

        if(s.length() != t.length())  return false;

        for(int i=0; i<n; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            //check if the last seen index for thse two characters are equal or not
            if(mapST[ch1] != mapTS[ch2]){
                return false;
            }
            mapST[ch1] = i+1;
            mapTS[ch2] = i+1;
        }
        return true;
    }
}
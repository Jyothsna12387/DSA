class Solution {
    public static int getMax(int[] freq){
        int max = 0;
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                max = Math.max(max,freq[i]);
            }
        }
        return max;
    }
    public static int getMin(int[] freq){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                min = Math.min(min,freq[i]);
            }
        }
        return min;
    }
    public int beautySum(String s) {
        int beauty = 0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];   //reset frequency array for new substring
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                beauty = beauty + (getMax(freq)-getMin(freq));
            }
        }
        return beauty;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxlen = 0;     //to store maximum length so far
        int maxfreq = 0;    //maximum count of a character 
   
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);

            freq[ch - 'A']++;
            maxfreq = Math.max(maxfreq, freq[ch - 'A']);
        
            //shrink if invalid window          
            if((right-left+1) - maxfreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}
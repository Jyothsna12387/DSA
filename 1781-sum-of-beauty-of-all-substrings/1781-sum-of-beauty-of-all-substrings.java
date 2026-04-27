class Solution {
    public int beautySum(String s) {
        int beauty = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            int[] freq = new int[26];   //reset frequency array for new substring
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int max = 0;
                int min = n;
                for(int count : freq){
                    if(count > 0){
                         max = Math.max(max,count);
                         min = Math.min(min,count);
                    }
                }
                beauty = beauty + (max-min);
            }
        }
        return beauty;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int[] pArr = new int[26];
        int[] sArr = new int[26];

        for(char ch : p.toCharArray()){
            pArr[ch - 'a']++;
        }

        int k = p.length();

        for(int i = 0; i < s.length(); i++){
            // add current character
            sArr[s.charAt(i) - 'a']++;

            // remove left character if window exceeds size
            if(i >= k){
                sArr[s.charAt(i - k) - 'a']--;
            }

            // compare arrays
            if(Arrays.equals(pArr, sArr)){
                list.add(i - k + 1);
            }
        }

        return list;
    }
}
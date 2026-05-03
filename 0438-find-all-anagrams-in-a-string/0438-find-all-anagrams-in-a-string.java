class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] pArr = new int[26];

        for(char ch : p.toCharArray()){
            pArr[ch - 'a']++;
        }
        int n = s.length();
        int k = p.length();
        for(int i=0; i<=n-k; i++){
            int[] freq = new int[26];
            for(int j=i; j<i+k; j++){
                freq[s.charAt(j) - 'a']++;
            }
            if(Arrays.equals(pArr,freq)){
                list.add(i);
            }
        }
        return list;
    }
}
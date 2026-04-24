class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                if(t.charAt(i) != map.get(ch)){
                    return false;
                }
            }
            else if(map.containsValue(t.charAt(i))){
                return false;
            }
            map.put(ch, t.charAt(i));
        }
        return true;
    }
}
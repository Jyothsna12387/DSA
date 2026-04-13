class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        //create hashmap
         HashMap <Character,Integer> map = new HashMap<>();

        // store 's' string in hashmap
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }  
        //decrement frequency through 't' string
        for(char c : t.toCharArray()){
            if(!map.containsKey(c))  return false;
            map.put(c,map.get(c)-1);
            if(map.get(c) == 0) map.remove(c);

        }
        //step 4: check for empty hashmap
        return map.isEmpty();
    }
}
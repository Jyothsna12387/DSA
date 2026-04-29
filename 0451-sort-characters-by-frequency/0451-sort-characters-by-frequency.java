class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        List<Character>[] bucket = new ArrayList[s.length()+1];

        //fill buckets
        for(char ch : map.keySet()){
            int freq = map.get(ch);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        //build result
        StringBuilder res = new StringBuilder();
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i] != null){
                for(char ch : bucket[i]){
                    res.append(String.valueOf(ch).repeat(i));
                }
            }
        }
        return res.toString();
    }
}
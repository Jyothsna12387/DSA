class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        //1. store the frequency of each character
        for(char c : s.toCharArray())
        {
            freq[c - 'a']++;
        }

        //step 2: process each character in given string
        for(char c : s.toCharArray()){
            freq[c - 'a']--;

            if(visited[c - 'a']) continue;  //continue if the current character is already in stack

            while(!stack.isEmpty() && c<stack.peek() && freq[stack.peek() - 'a']>0){
                visited[stack.pop()-'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        //3. buils result
        StringBuilder result = new StringBuilder();
        for(char c : stack){
            result.append(c);
        }
        return result.toString();
    }
}
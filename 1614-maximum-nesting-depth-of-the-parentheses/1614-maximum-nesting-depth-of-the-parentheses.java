import java.util.*;

class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } 
            if (ch == ')') {
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }

        return maxDepth;
    }
}
import java.util.*;

class Solution {
    public int solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
            }
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
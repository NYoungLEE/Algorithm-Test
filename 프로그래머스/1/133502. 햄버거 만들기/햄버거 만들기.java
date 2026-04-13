import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for (int num : ingredient) {
            stack.push(num);
            
            if (stack.size() >= 4) {
                int a = stack.pop();
                int b = stack.pop();
                int c = stack.pop();
                int d = stack.pop();
                
                if (d == 1 && c == 2 && b == 3 && a == 1) {
                    answer++;
                } else {
                    stack.push(d);
                    stack.push(c);
                    stack.push(b);
                    stack.push(a);
                }
            }
        }

        return answer;
    }
}
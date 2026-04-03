import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = prices.length - 1; i >= 0; i--) {
            stack.push(prices[i]);
        }
        
        while (!stack.isEmpty()) {
            int now = stack.get(stack.size() - 1);
            int cnt = 0;
            
            for (int i = stack.size() - 2; i >= 0; i--) {
                cnt++;
                if (stack.get(i) < now) break;
            }
            
            list.add(cnt);
            stack.pop();
        }
        
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
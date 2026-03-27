import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));

        for (String str : goal) {
            if (str.equals(queue1.peek())) queue1.poll();
            else if (str.equals(queue2.peek())) queue2.poll();
            else return "No";
        }
        
        return "Yes";
    }
}
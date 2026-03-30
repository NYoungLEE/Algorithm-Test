import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations) {
            String[] s = str.split(" ");
            
            if(s[0].equals("D") && minPQ.isEmpty()) {
                continue;
            }
            
            if(s[0].equals("I")) {
                int num = Integer.parseInt(s[1]);
                minPQ.offer(num);
                maxPQ.offer(num);
            } else if (s[0].equals("D") && s[1].equals("1")) {
                int value = maxPQ.poll();
                minPQ.remove(value);
            } else {
                int value = minPQ.poll();
                maxPQ.remove(value);
            }
        }
        
        if (minPQ.isEmpty()) return new int[] {0, 0};
        return new int[]{maxPQ.peek(), minPQ.peek()};
    }
}
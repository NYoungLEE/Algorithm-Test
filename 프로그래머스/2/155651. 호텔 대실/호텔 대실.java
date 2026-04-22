import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(toMinute(book_time[0][1]) + 10);
        
        for (int i = 1; i < book_time.length; i++) {
            int start = toMinute(book_time[i][0]);
            int end = toMinute(book_time[i][1]) + 10;

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
        }
        
        return pq.size();
    }
    
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
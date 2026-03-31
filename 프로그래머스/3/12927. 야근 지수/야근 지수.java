import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            queue.offer(work);
        }
        
        while (n > 0) {
            int tmp = queue.poll();
            if (tmp == 0) break;
            queue.offer(--tmp);
            n--;
        }
        
        while (!queue.isEmpty()) {
            int t = queue.poll();
            answer += Math.pow(t, 2);
        }
        
        return answer;
    }
}
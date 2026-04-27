import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            pq.offer(enemy[i]);
            
            if (sum > n) {
                if (k > 0) {
                    sum -= pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        int time = 0; int idx = 0;
        int answer = 0;
        while (idx < jobs.length || !pq.isEmpty()) {
            
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            int[] cur = pq.poll();
            time += cur[1];
            
            answer += (time - cur[0]);
        }
        
        return answer / jobs.length;
    }
}
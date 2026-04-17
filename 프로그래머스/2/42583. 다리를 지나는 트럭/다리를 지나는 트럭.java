import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>(); 
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int idx = 0;
        int sum = 0;
        while (true) {
            if (idx == truck_weights.length) break;
            
            sum -= bridge.poll();
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
            answer++;
        }
        
        return answer + bridge_length;
    }
}

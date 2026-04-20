import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        Arrays.sort(weights);
        
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();
        
        for (int w : weights) {
            answer += map.getOrDefault(w, 0L);
            
            if (w * 2 % 3 == 0) {
                answer += map.getOrDefault(w * 2 / 3, 0L);
            }
            if (w % 2 == 0) {
                answer += map.getOrDefault(w / 2, 0L);
            }
            if (w * 3 % 4 == 0) {
                answer += map.getOrDefault(w * 3 / 4, 0L);
            }
            
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        boolean isDuplicate = false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            if(entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
                isDuplicate = false;
                
            } else if (entry.getValue() == max) isDuplicate = true;
        }
        
        return isDuplicate ? -1 : answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        for (String str : keymap) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                int press = i + 1;
                
                map.put(ch, Math.min(map.getOrDefault(ch, Integer.MAX_VALUE), press));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean possible = true;
            
            for (char ch : targets[i].toCharArray()) {
                if (!map.containsKey(ch)) {
                    possible = false;
                    break;
                }
                sum += map.get(ch);
            }
            
            answer[i] = possible ? sum : -1;
        }
        
        return answer;
    }
}
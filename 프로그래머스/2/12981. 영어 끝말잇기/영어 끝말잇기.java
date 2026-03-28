import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                String s1 = words[i];
                String s2 = words[i - 1];
                
                char first = s1.charAt(0);
                char last = s2.charAt(s2.length() - 1);
                
                if (map.containsKey(s1) || last != first) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
            }
            
            map.put(words[i], 1);
        }

        return answer;
    }
}
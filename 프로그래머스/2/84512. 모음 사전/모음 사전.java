import java.util.*;

class Solution {
    
    private static List<String> list;
    private static String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        dfs("", 0);
        
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private void dfs(String word, int depth) {
        
        list.add(word);
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(word + words[i], depth + 1);
        }
    }
}
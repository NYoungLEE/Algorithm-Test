import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        /* 풀이1
        String answer = "";
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        String[] arr = my_string.split("");
        
        for (String s : arr) {
            set.add(s);
        }
        
        answer = String.join("", set);
        
        return answer; */
        
        // 풀이2
        String[] answer = my_string.split("");
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(answer));
        
        return String.join("", set);
    }
}
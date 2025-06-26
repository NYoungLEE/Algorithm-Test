import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        String answer = "";
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        String[] arr = my_string.split("");
        
        for (String s : arr) {
            set.add(s);
        }
        
        answer = String.join("", set);
        
        return answer;
    }
}
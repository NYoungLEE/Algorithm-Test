import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        String[] str =  my_string.replaceAll("[a-z]", "").split("");
        
        int[] answer = Arrays.stream(str)
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        
        return answer;
    }
}
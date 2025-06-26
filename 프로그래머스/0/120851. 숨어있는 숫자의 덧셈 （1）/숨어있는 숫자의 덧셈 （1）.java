import java.util.*;

class Solution {
    public int solution(String my_string) {
        
        String[] arr = my_string.replaceAll("[^0-9]", "").split("");
        
        int answer = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();

        return answer;
    }
}
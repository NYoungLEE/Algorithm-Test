import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        // 방법1
        int count = 0;
    
        for(int n : arr) {
            if (n % divisor == 0) count++;
        }
        
         if (count == 0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[count];
        
        int index = 0;
        
        for(int n : arr) {
            if (n % divisor == 0) answer[index++] = n;
        }
        
        Arrays.sort(answer);
        
        return answer;
        
        /* 방법2
        int[] answer = Arrays.stream(arr)
            .filter(n -> n % divisor == 0)
            .sorted()
            .toArray();
        
        return answer.length == 0 ? new int[] {-1} : answer; */
                    
    }
}
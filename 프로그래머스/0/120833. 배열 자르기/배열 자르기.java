import java.util.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        
        /* int[] answer = new int[num2 - num1 + 1];
        
        int pos = 0;
        
        for(int i = num1; i <= num2; i++) answer[pos++] = numbers[i];
          
        return answer; */
        
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
import java.util.*;

class Solution {
    public int solution(int[] sides) {
        
        int answer = 0;
        
        Arrays.sort(sides);
        
        int num1 = sides[0];
        int num2 = sides[1];
        
        // num1이 가장 긴 변인 경우
        for(int i = num2 - num1 + 1 ; i <= num2; i++) {
            answer++;
        }
        
        // 나머지 한 변이 가장 긴 변인 경우
        for(int i = num2 + 1; i < num1 + num2; i++) {
            answer++;
        }
    
        return answer;
    }
}
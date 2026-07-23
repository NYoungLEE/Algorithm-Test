import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int target1 = scores[0][0];
        int target2 = scores[0][1];
        int target = target1 + target2;
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int answer = 1;
        int maxSecond = 0;
        for (int[] score : scores) {
            
            int first = score[0];
            int second = score[1];
            
            if (second < maxSecond) {
                if (target1 == first && target2 == second) return -1;
            } else {
                
                maxSecond = second;
                
                if (first + second > target) answer++;
            }
        }
        
        return answer;
    }
}
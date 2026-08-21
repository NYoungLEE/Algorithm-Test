import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int point = 0; int answer = 0;
        for (int[] target : targets) {
            if (point <= target[0]) {
                point = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}
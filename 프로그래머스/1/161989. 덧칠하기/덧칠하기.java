import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int end = section[0] + m - 1;
        
        for (int num : section) {
            if (num > end) {
                end = num + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}
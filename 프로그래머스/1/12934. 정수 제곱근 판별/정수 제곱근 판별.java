import java.util.*;

class Solution {
    public long solution(long n) {
        
        long sqrt = (long) Math.sqrt(n);
        
        long answer = (sqrt * sqrt == n) ? (long) Math.pow(sqrt + 1, 2) : -1;
        
        return answer;
    }
}
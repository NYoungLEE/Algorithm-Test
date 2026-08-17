import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        List<Integer> answer = new ArrayList<>();
        
        for (long i = begin; i <= end; i++) {         
            answer.add((int) block(i));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private long block(long n) {
        
        if (n == 1) return 0;
        
        long max = 1;
        
        for (long i = 2; i <= Math.sqrt(n); i++) {
          
            if (n % i == 0) {
                long divisor = n / i;
                max = i;
                
                if (divisor <= 10000000) return divisor;
            }
        }
        
        return max;
    }
}
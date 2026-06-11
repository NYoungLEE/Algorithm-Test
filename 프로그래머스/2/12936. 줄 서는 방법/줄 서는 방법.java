import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        long factorial = 1;
        
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        
        int[] answer = new int[n];
        k--;
        
        for (int i = 0; i < n; i++) {
            
            int idx = (int) (k / factorial);
            answer[i] = numbers.remove(idx);
            
            if (numbers.isEmpty()) {
                break;
            }
            
            k %= factorial;
            factorial /= numbers.size();
        }
        
        return answer;
    }
}
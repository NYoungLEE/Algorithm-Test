import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int len = topping.length;
        
        Set<Integer> leftSet = new HashSet<>();
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            leftSet.add(topping[i]);
            left[i] = leftSet.size();
        }
            
        Set<Integer> rightSet = new HashSet<>();
        int[] right = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            right[i] = rightSet.size();
        }
        
        int answer = 0;
        for (int i = 0; i < len - 1; i++) {
            if (left[i] == right[i + 1]) answer++;
        }
        
        
        return answer;
    }
}
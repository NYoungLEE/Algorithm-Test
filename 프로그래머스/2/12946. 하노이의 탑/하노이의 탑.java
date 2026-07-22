import java.util.*;

class Solution {
    
    public List<int[]> answer;
    
    public int[][] solution(int n) {
        
        answer = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        
        return answer.toArray(new int[0][]);
    }
    
    private void hanoi (int n, int from, int to, int via) {
        
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        
        hanoi(n-1, from, via, to);
        
        answer.add(new int[]{from, to});
        
        hanoi(n-1, via, to, from);
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                int doll = board[i][m - 1];
                if (doll != 0) {
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}
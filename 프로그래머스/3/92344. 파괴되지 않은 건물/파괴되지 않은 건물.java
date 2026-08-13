import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int answer = 0;
        
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N + 1][M + 1];
        
        for (int[] s : skill) {
            int r1 = s[1]; int c1 = s[2];
            int r2 = s[3]; int c2 = s[4];
            
            int degree = (s[0] == 1)? -s[5] : s[5];
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sum[r][c] += sum[r - 1][c];
            }
        }
        
        for (int c = 1; c < M; c++) {
            for (int r = 0; r < N; r++) {
                sum[r][c] += sum[r][c - 1];
            }
        }
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] + sum[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
}
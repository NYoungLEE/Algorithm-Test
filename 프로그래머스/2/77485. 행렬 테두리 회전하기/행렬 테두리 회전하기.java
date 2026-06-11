class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] board = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for (int[] q : queries) {
            int x1 = q[0] - 1; int y1 = q[1] - 1;
            int x2 = q[2] - 1; int y2 = q[3] - 1;
                        
            int temp = board[x1][y1];
            int min = temp;
            
            for (int x = x1; x < x2; x++) {
                board[x][y1] = board[x + 1][y1];
                min = Math.min(min, board[x][y1]);
            }
            for (int y = y1; y < y2; y++) {
                board[x2][y] = board[x2][y + 1];
                min = Math.min(min, board[x2][y]);
            }
            for (int x = x2; x > x1; x--) {
                board[x][y2] = board[x - 1][y2];
                min = Math.min(min, board[x - 1][y2]);
            }
            for (int y = y2; y > y1; y--) {
                board[x1][y] = board[x1][y - 1];
                min = Math.min(min, board[x1][y - 1]);
            }
            board[x1][y1 + 1] = temp;
            
            answer[idx++] = min;
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[][] board) {
        
        int x = board.length;
        int answer = 0;
        
        // 위험 지역 분류
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                if(board[i][j] == 1) danger(board, i, j);
            }
        }
        
        // 안전 지역 찾기
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++){
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    public void danger(int[][] board, int x, int y) {
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                
                int nx = x + i;
                int ny = y + j;
                
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
                
                if(board[nx][ny] != 1) {
                    board[nx][ny] = 2;   
                }
            }
        }
    }
}
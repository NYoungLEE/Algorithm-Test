class Solution {
    public int solution(int m, int n, String[] board) {
        
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        while (true) {
            boolean[][] remove = new boolean[m][n];
            boolean found = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char ch = map[i][j];
                    if (ch != 'X'
                       && ch == map[i][j + 1]
                       && ch == map[i + 1][j]
                       && ch == map[i + 1][j + 1]) {
                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }
            
            if (!found) break;
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        map[i][j] = 'X';
                        answer++;
                    }
                }
            }
            
            for (int col = 0; col < n; col++) {
                int empty = m - 1;
                for (int row = m - 1; row >= 0; row--) {
                    if (map[row][col] != 'X') {
                        map[empty][col] = map[row][col];
                        if (empty != row) map[row][col] = 'X';
                        empty--;
                    }
                }
            }
        }
        
        return answer;
    }
}
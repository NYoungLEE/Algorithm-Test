class Solution {
    public int[] solution(int n) {
        int len = n * (n + 1) / 2;
        int[] answer = new int[len];
        
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
        }

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int x = 0, y = 0, dir = 0;
        
        for (int i = 1; i <= len; i++) {
            arr[x][y] = i;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= n || ny < 0 || ny > nx || arr[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
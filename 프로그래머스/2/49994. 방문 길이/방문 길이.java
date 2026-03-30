import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        boolean[][][] visited = new boolean[11][11][4];
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        
        int answer = 0;
        int cx = 5; int cy = 5; int d = 0;
        
        for (char ch : dirs.toCharArray()) {
            if (ch == 'U') d = 0;
            else if (ch == 'R') d = 1;
            else if (ch == 'D') d = 2;
            else if (ch == 'L') d = 3;
            
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            if (!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[cx][cy][(d + 2) % 4] = true;
                answer++;
            }
            
            cx = nx; cy = ny;
        }
        
        return answer;
    }
}
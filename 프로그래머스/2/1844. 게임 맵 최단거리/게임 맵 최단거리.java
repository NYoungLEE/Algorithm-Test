import java.util.*;

class Solution {
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    private int[][] visited;
    
    public int solution(int[][] maps) {

        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];
        
        bfs(maps);
        answer = visited[n - 1][m - 1];
        
        if (answer == 0) return -1;

        return answer;
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[cx][cy] + 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
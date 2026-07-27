import java.util.*;

class Solution {
    
    private static final int SIZE = 101;
    
    public int[][] map = new int[SIZE][SIZE];
    public boolean[][] visited = new boolean[SIZE][SIZE];
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 1. 좌표 2배 + 사각형 전체 채우기
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        // 2. 사각형 내부 제거
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }
        
        // 3. BFS
        int distance = bfs(characterX, characterY, itemX, itemY);
        
        return distance;
    }
    
    private int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        
        int cx = characterX * 2;
        int cy = characterY * 2;
        int ix = itemX * 2;
        int iy = itemY * 2;
        
        queue.offer(new int[] {cx, cy, 0});
        visited[cx][cy] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            if (x == ix && y == iy) return dist / 2;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) continue;
                
                if (visited[nx][ny]) continue;
                
                if (map[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, dist + 1});
            }
        }
        
        return 0;
    }
}
import java.util.*;

class Solution {
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public int n, m;
    public int[] oil;
    
    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, visited, i, j);
                }
            }
        }
                
        int answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    private void bfs(int[][] land, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            set.add(now[1]);
            
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }
        
        for (int index : set) {
            oil[index] += count;
        }
    }
}
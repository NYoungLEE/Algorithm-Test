import java.util.*;

class Solution {
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public List<Integer> result;
    public boolean[][] visited;
    
    public int[] solution(String[] maps) {
        
        result = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    bfs(i, j, maps);
                }
            }
        }
     
        if (result.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public void bfs(int x, int y, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            sum += maps[cur[0]].charAt(cur[1]) - '0';
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) continue;
                if (visited[nx][ny] == true || maps[nx].charAt(ny) == 'X') continue;
                
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        result.add(sum);
    }
}
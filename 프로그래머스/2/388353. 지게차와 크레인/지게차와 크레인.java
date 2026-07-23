import java.util.*;

class Solution {
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public char[][] map;
    
    public int solution(String[] storage, String[] requests) {
        
        map = new char[storage.length + 2][storage[0].length() + 2];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        for (String r : requests) {
            char target = r.charAt(0);
            
            // 크레인 이용
            if (r.length() == 2) {
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j] == target) map[i][j] = '.';
                    }
                }
            }
            // 지게차 이용
            else {
                bfs(target);
            }
        }
        
        
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != '.') answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        List<int[]> remove = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                
                if (visited[nx][ny]) continue;
                
                if (map[nx][ny] == '.') {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else if (map[nx][ny] == target) {
                    remove.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        for (int[] pos : remove) {
            map[pos[0]][pos[1]] = '.';
        }
    }
}
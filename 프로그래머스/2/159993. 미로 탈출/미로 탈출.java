import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0, -1, 1};
    
    public int solution(String[] maps) {
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (ch == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int dist1 = bfs(start, lever, maps);
        int dist2 = bfs(lever, end, maps);

        if (dist1 == -1 || dist2 == -1) return -1;
        
        return dist1 + dist2;
    }
    
    private static int bfs(int[] start, int[] end, String[] maps) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        queue.offer(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int dist = cur.dist;
            
            if (cx == end[0] && cy == end[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) continue;
                if (maps[nx].charAt(ny) == 'X') continue;
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, dist + 1));
            }
        }
        
        return -1;
    }
    
    public static class Node {
        int x;
        int y;
        int dist;
        
        public Node (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
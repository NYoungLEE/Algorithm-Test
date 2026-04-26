import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(String[] board) {
        
        int[] start = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        visited = new boolean[board.length][board[0].length()];
        int answer = bfs(start, board);
    
        return answer;
    }
    
    private int bfs(int[] start, String[] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if (board[cur.x].charAt(cur.y) == 'G') {
                return cur.dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int cx = cur.x;
                int cy = cur.y;

                while (true) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length()
                        || board[nx].charAt(ny) == 'D') {
                        break;
                    }

                    cx = nx;
                    cy = ny;
                }

                if (!visited[cx][cy]) {
                    visited[cx][cy] = true;
                    queue.offer(new Node(cx, cy, cur.dist + 1));
                }
            }
        }
        
        return -1;
    }
    
    public class Node {
        int x; int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
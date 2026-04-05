import java.util.*;

class Solution {
    
    public int solution(int[][] board) {
        
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, -1));
        cost[0][0][0] = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
    
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                if(board[nx][ny] == 1) continue;
                
                int newCost = now.cost;
                if (now.dir == -1 || now.dir == dir) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }
                
                if (newCost <= cost[nx][ny][dir]) {
                    cost[nx][ny][dir] = newCost;
                    queue.offer(new Node(nx, ny, newCost, dir));
                }
            }
        }

        int answer = Math.min(Math.min(cost[n-1][n-1][0], cost[n-1][n-1][1]),
                      Math.min(cost[n-1][n-1][2], cost[n-1][n-1][3]));
        
        return answer;
    }
    
    public static class Node {
        int x, y, cost, dir;
        
        public Node (int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
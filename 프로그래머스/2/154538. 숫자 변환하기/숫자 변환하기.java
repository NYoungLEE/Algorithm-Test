import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {      
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        queue.offer(new Node(x, 0));
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            int count = now.count;
            
            if (num == y) return count;
            
            int[] next = {num + n, num * 2, num * 3};
            
            for (int nn : next) {
                if (nn <= y && !visited[nn]) {
                    visited[nn] = true;
                    queue.offer(new Node(nn, count + 1));
                }
            }
        }
        
        return -1;
    }
    
    public static class Node {
        int num;
        int count;
        
        public Node (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
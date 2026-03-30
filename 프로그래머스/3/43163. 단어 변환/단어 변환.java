import java.util.*;

class Solution {
    
    private static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            String now = cur.word;
            int depth = cur.depth;
            
            if (now.equals(target)) return depth;
            
            for (int i = 0; i < words.length; i++) {
                int diff = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (now.charAt(j) != (words[i].charAt(j))) diff++;
                }
                
                if (diff == 1 && !visited[i]) {
                    queue.offer(new Node(words[i], depth + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public static class Node {
        String word;
        int depth;
        
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
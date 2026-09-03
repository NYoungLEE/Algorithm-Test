import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {

        List<List<int[]>> paths = new ArrayList<>();
        
        for (int i = 0; i < routes.length; i++) {
            List<int[]> path = new ArrayList<>();
            
            int[] now = points[routes[i][0] - 1];
            int nowR = now[0];
            int nowC = now[1];
            
            path.add(new int[] {nowR, nowC});
            
            for (int j = 1; j < routes[i].length; j++) {
                int[] next = points[routes[i][j] - 1];
                int nextR = next[0];
                int nextC = next[1];
                
                while (nowR != nextR) {
                    nowR += (nowR < nextR) ? 1 : -1;
                    path.add(new int[] {nowR, nowC});
                }
                
                while (nowC != nextC) {
                    nowC += (nowC < nextC) ? 1 : -1;
                    path.add(new int[] {nowR, nowC});
                }
            }
            
            paths.add(path);
        }
        
        int maxTime = 0;
        for (List<int[]> path : paths) {
            maxTime = Math.max(maxTime, path.size());
        }
        
        int answer = 0;
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> count = new HashMap<>();
            
            for (List<int[]> path : paths) {
                if (t >= path.size()) continue;
                
                int[] pos = path.get(t);
                
                String key = pos[0] + "," + pos[1];
                
                count.put(key, count.getOrDefault(key, 0) + 1);
            }
            
            for (int value : count.values()) {
                if (value >= 2) answer++;
            }
        }
        
        return answer;
    }
}
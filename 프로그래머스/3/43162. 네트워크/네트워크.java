// DFS 활용
class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false) {
                dfs(i, n, computers);
                answer++;
            }         
        }
        
        return answer;
    }
    
    private void dfs(int i, int n, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < computers[i].length; j++) {
            if (visited[j] == false && computers[i][j] == 1) {
                dfs(j, n, computers);
            }
        }
    }
}
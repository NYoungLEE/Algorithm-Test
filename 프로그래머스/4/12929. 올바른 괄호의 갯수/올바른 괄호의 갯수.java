class Solution {
    
    public int answer = 0;
    
    public int solution(int n) {
        
        dfs(n * 2, 1, 1);
        
        return answer;
    }
    
    private void dfs(int max, int depth, int sum) {
        if (sum < 0) return;
        
        if (depth == max) {
            if (sum == 0) answer++;
            return;
        }
        
        dfs(max, depth + 1, sum + 1);
        dfs(max, depth + 1, sum - 1);
    }
}
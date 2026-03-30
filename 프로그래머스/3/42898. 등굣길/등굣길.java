class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        boolean[][] puddle = new boolean[m + 1][n + 1];
        
        for (int i = 0; i < puddles.length; i++) {
            puddle[puddles[i][0]][puddles[i][1]] = true;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                if (puddle[i][j]) continue;
    
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= 1000000007;
            }
        }
        
        return dp[m][n];
    }
}
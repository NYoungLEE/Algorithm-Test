import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int m : money) {
            for (int price = m; price <= n; price++) {
                dp[price] += dp[price - m];
            }
        }        
        
        return dp[n];
    }
}
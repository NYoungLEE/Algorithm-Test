import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
         Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int count = 0;
        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int price = cost[2];
            
            if (union(start, end)) {
                answer += price;
                count++;
                
                if (count == n - 1) break;
            }
        }
        
        return answer;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) return false;
        
        parent[rootB] = rootA;
        return true;
    }
}
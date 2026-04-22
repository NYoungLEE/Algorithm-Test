class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] running = new int[24];
        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;
            
            if (need > running[i]) {
                int add = need - running[i];
                answer += add;
                
                for (int j = 1; j < Math.min(24, i + k); j++) {
                    running[j] += add;
                }
            }

        }
        
        return answer;
    }
}
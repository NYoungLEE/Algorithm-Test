class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        boolean isPlus = true;
        
        long dp1 = 0;
        long dp2 = 0;
        
        for (int num : sequence) {
            dp1 += isPlus ? num : -num;
            dp2 += isPlus ? -num : num;
            
            dp1 = Math.max(0, dp1);
            dp2 = Math.max(0, dp2);
            
            answer = Math.max(answer, Math.max(dp1, dp2));
            
            isPlus = !isPlus;
        }
        
        return answer;
    }
}
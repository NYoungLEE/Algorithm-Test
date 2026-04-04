class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int prev = 1;
        int len = 2 * w + 1;
        for (int station : stations) {
            int left = station - w;
            
            int gap = left - prev;
            if(gap > 0) {
                answer += (gap + len - 1) / len;
            }
            
            prev = station + w + 1;
        }
        
        if (prev <= n) {
            int gap = n - prev + 1;
            answer += (gap + len - 1) / len;
        }

        return answer;
    }
}
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int base = s / n;
        int remain = s % n;
        
        if (base == 0) return new int[] {-1};
        
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = base;
            if (remain > 0) {
                answer[i] += 1;
                remain--;
            }
        }
        
        return answer;
    }
}
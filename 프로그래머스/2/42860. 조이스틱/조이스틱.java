class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 1. 세로 이동
        for (char ch : name.toCharArray()) {
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        // 2. 가로 이동
        int move = name.length() - 1;
        int n = name.length();
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + n - next);
            move = Math.min(move, (n - next) * 2 + i);
        }
        
        return answer + move;
    }
}
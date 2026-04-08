class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int same = 0;
        int diff = 0;
        char x = 0;
        
        for (char ch : s.toCharArray()) {
            if (same == 0) {
                x = ch;
            }
            
            if (ch == x) same++;
            else diff++;
            
            if(same == diff) {
                same = 0;
                diff = 0;
                answer++;
            }
        }
        
        if (same != 0) answer++;
        
        return answer;
    }
}
class Solution {
    public int solution(int a, int b) {
        
        int num = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        
        int answer = num >= (2 * a * b) ? num : 2 * a *b;
        return answer;
    }
}
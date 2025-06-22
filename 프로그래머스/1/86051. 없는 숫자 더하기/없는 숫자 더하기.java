class Solution {
    public int solution(int[] numbers) {
        
        int answer = 9 * 10 / 2;  // 0~9까지의 합
        
        for(int n : numbers) answer -= n;
        
        return answer;
    }
}
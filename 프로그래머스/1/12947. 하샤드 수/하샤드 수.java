class Solution {
    public boolean solution(int x) {
        
        int sum = 0;
        int num = x;
        
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        
        boolean answer = (num % sum == 0) ? true : false;
            
        return answer;
    }
}
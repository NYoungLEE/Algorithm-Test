class Solution {
    public String solution(int n) {
        
        String answer = "";
        
        while (n > 0) {
            int r = (n - 1) % 3;

            if (r == 0) {
                answer = "1" + answer;
                n /= 3;
            } else if (r == 1) {
                answer = "2" + answer;
                n /= 3;
            } else {
                answer = "4" + answer;
                n = n / 3 - 1;
            }
        }
        
        return answer;
    }
}
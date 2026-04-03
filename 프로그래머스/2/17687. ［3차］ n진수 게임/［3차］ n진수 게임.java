class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String temp = ""; 
        int num = 0;
        while (temp.length() < t * m) {
            temp += Integer.toString(num++, n);
        }
        
        for (int i = p - 1; i < t * m; i += m) {
            answer += temp.charAt(i);
        }
        
        return answer.toUpperCase();
    }
}
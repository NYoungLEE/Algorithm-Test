class Solution {
    public String solution(String s) {
        
        String answer = "";
        String[] arr = s.split("");
        int cnt = 0;
        
        for (String str : arr) {
            cnt = (str.equals(" ")) ? 0 : cnt + 1;
            answer += (cnt % 2 == 1) ? str.toUpperCase() : str.toLowerCase();
        }
        
        return answer;
    }
}
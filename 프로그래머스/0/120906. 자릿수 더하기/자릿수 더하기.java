class Solution {
    public int solution(int n) {
        
        String number = Integer.toString(n);
        String[] arr = number.split("");
        
        int answer = 0;
        
        for(String num : arr) {
            answer += Integer.parseInt(num);
        }
        
        return answer;
    }
}
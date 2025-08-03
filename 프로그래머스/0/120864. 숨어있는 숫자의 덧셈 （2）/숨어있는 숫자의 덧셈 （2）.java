class Solution {
    public int solution(String my_string) {
        
        int answer = 0;
        
        String[] arr = my_string.split("[a-zA-Z]+");
        
        for(String str : arr) {
            try {
                answer += Integer.parseInt(str);
            } catch (Exception e) {
                continue;
            }
        }      
        
        return answer;
    }
}
class Solution {
    public String solution(String my_string) {
        
        String answer = "";
        char[] arr = my_string.toCharArray();
        
        for(char c : arr) {
            if(Character.isUpperCase(c)) answer += Character.toLowerCase(c);
            else answer += Character.toUpperCase(c);
        }

        return answer;
    }
}
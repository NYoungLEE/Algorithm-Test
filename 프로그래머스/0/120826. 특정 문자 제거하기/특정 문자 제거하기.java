class Solution {
    public String solution(String my_string, String letter) {
        
        /* StringBuilder sb = new StringBuilder();
        char target = letter.charAt(0);
        
        for(char c : my_string.toCharArray()) {
            if(c != target) sb.append(c);
        }
        
        return sb.toString(); */
        
        return my_string.replace(letter, "");
    }
}
class Solution {
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            answer[i] = solve(s[i]);
        }
        
        return answer;
    }
    
    private String solve (String s) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (sb.length() >= 2 && c == '0'
                && sb.charAt(sb.length() - 2) == '1'
                && sb.charAt(sb.length() - 1) == '1') {
                temp.append("110");
                sb.delete(sb.length() -2, sb.length());
            } else {
                sb.append(c);
            }
        }
        
        if (temp.length() > 0) {
            if (sb.indexOf("0") == -1) {
                sb.insert(0, temp);
            } else {
                int idx = sb.lastIndexOf("0");
                sb.insert(idx + 1, temp);
            }
        }
        
        return sb.toString();
    }
}
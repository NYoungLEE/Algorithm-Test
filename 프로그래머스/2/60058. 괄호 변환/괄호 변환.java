class Solution {
    public String solution(String p) {
        
        if (p.isEmpty()) return "";
        
        String u = ""; String v = "";
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') sum++;
            if (p.charAt(i) == ')') sum--;
            
            u = p.substring(0, i + 1);
            if (sum == 0) {
                v = p.substring(i + 1);
                break;
            }
        }

        if (isCorrect(u)) return u + solution(v);
        
        StringBuilder sb = new StringBuilder();
        sb.append("(" + solution(v) + ")");
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        
        return sb.toString();
    }
    
    private boolean isCorrect (String s) {
        int cnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;
            
            if (cnt < 0) {
                return false;
            }
        }
        
        return true;
    }
}
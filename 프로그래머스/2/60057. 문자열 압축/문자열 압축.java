class Solution {
    public int solution(String s) {
        
        if (s.length() == 1) return 1;
        
        int answer = Integer.MAX_VALUE;
        
        for (int size = 1; size <= s.length() / 2; size++) {
            
            StringBuilder sb = new StringBuilder();
            
            String prev = "";
            int count = 0;
            
            for (int i = 0; i < s.length(); i += size) {
                
                String cur = s.substring(i, Math.min(s.length(), i + size));
                
                if (cur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    
                    sb.append(prev);
                    
                    prev = cur;
                    count = 1;
                }
            }
            
            if (count > 1) sb.append(count);
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
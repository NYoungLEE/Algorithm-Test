import java.util.*;

class Solution {
    public long solution(long n) {
        
        String[] num = Long.toString(n).split("");
        
        Arrays.sort(num, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String s : num) sb.append(s);
        
        return Long.parseLong(sb.toString());
    }
}
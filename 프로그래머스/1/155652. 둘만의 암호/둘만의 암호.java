import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        List<Character> list = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            if (skip.indexOf(c) == -1) {
                list.add(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            int pos = list.indexOf(c);
            int next = (pos + index) % list.size();
            sb.append(list.get(next));
        }
        
        return sb.toString();
    }
}
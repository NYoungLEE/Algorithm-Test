import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {

        /* 풀이1
        int[] answer = new int[strlist.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strlist[i].length();
        }
        
        return answer; */
        
        // 풀이2
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }
}
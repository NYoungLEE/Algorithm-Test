import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] arr = s.split("");
        String answer = "";
        int cnt = 0;
        
        Arrays.sort(arr);
        
        for(String sg : arr) {
            cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                if(sg.equals(arr[i])) cnt++;
            }
            if(cnt == 1) answer += sg;
        }
        
        return answer;
    }
}
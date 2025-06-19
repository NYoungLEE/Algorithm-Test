import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        
        int[] answer = new int[emergency.length];
        
        for (int i = 0; i < emergency.length; i++) {
            int pos = 1;
            for (int j = 0; j < emergency.length; j++) {
                if(emergency[i] < emergency[j]) pos++;
            }
            answer[i] = pos;
        }
        
        /* 풀이2
        int[][] indexedPos = new int[emergency.length][2];
        for (int i = 0; i < emergency.length; i++) {
            indexedPos[i][0] = emergency[i];
            indexedPos[i][1] = i;
        }
        
        // 내림차순으로 정렬
        Arrays.sort(indexedPos, (a, b) -> Integer.compare(b[0], a[0]));
        
        
        for (int pos = 0; pos < emergency.length; pos++) {
            int rank = indexedPos[pos][1];
            answer[rank] = pos + 1;
        } */
             
        return answer;
    }
}
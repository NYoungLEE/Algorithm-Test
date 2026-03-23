import java.util.*;

class Solution {
    public long solution(long n) {
        
        String[] arr = Long.toString(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }

        return Long.parseLong(sb.toString());
    }
}
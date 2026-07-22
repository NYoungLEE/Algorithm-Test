import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canClear(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean canClear(int[] diffs, int[] times, long limit, int level) {
        
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                if (i == 0) total += (times[0] * (diffs[0] - level + 1));
                else total += ((long) (times[i] + times[i - 1]) * (diffs[i] - level) + times[i]);
            }
        }
        
        return total <= limit ? true : false;
    }
}
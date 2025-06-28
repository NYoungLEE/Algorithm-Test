import java.util.*;

class Solution {
    public int solution(int order) {
        
        int count = 0;
        
        while (order > 0) {
            int digit = order % 10;
            if (digit != 0 && digit % 3 == 0) count++;
            order /= 10;
        }
        
        return count;
    }
}
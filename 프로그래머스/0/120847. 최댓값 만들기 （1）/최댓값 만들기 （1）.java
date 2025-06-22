import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        /* 방법1
        int first = 0; int second = 0;
        
        for (int num : numbers) {
            if(num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        
        
        return first * second; */
        
        // 방법2
        Arrays.sort(numbers);
        
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }
}
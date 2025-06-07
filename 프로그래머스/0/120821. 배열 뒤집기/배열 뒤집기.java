import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = IntStream.range(0, num_list.length)
                                .map(n -> num_list[num_list.length - n - 1])
                                .toArray();
        
        return answer;
    }
}
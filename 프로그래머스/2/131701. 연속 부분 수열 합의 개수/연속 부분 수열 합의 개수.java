import java.util.*;

class Solution {
    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        
        int len = 1;
        while (len <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int value = 0;
                for (int j = i; j < i + len; j++) {
                    value += elements[j % elements.length];
                }
                set.add(value);
            }
            len++;
        }
        
        return set.size();
    }
}
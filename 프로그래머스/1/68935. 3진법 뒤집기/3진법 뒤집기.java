import java.util.*;

class Solution {
    public int solution(int n) {

        String str = new StringBuilder(Integer.toString(n, 3))
            .reverse().toString();

        return Integer.parseInt(str, 3);
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : win_nums) set.add(n);

        int zero = 0;
        int same = 0;

        for (int lotto : lottos) {
            if (lotto == 0) zero++;
            else if (set.contains(lotto)) same++;
        }

        int max = same + zero;
        int min = same;

        return new int[]{rank(max), rank(min)};
    }

    private int rank(int n) {
        return Math.min(7 - n, 6);
    }
}
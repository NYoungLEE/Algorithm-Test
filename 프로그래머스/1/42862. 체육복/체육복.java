import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        for (int num : lost) lostSet.add(num);
        Set<Integer> reserveSet = new HashSet<>();
        for (int num : reserve) reserveSet.add(num);
        Set<Integer> intersectSet = new HashSet<>(lostSet);
        intersectSet.retainAll(reserveSet);
        lostSet.removeAll(intersectSet);
        reserveSet.removeAll(intersectSet);
        
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }
        
        return n - lostSet.size();
    }
}
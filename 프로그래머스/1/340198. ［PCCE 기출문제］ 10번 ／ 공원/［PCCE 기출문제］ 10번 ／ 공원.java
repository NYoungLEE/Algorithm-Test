import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            for (int j = 0; j <= park.length - size; j++) {
                for (int k = 0; k <= park[j].length - size; k++) {
                    if(canPlace(park, j, k, size)) return mats[i];
                }
            }
        }
        
        return -1;
    }
    
    private boolean canPlace(String[][] park, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(!park[i][j].equals("-1")) return false;
            }
        }
        
        return true;
    }
}
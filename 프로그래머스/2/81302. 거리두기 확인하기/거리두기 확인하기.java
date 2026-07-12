import java.util.*;

class Solution {
    
    public int[] solution(String[][] places) {
    
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            answer[i] = check(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean check(String[] place) {
        
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                
                if (place[r].charAt(c) != 'P') continue;
                
                // 상하좌우 (d = 1)
                if (isPerson(place, r - 1, c)) return false;
                if (isPerson(place, r + 1, c)) return false;
                if (isPerson(place, r, c - 1)) return false;
                if (isPerson(place, r, c + 1)) return false;
                
                // 상하좌우 (d = 2)
                if (isPerson(place, r - 2, c)
                    && place[r - 1].charAt(c) != 'X') return false;
                if (isPerson(place, r + 2, c)
                    && place[r + 1].charAt(c) != 'X') return false;
                if (isPerson(place, r, c - 2)
                    && place[r].charAt(c - 1) != 'X') return false;
                if (isPerson(place, r, c + 2)
                    && place[r].charAt(c + 1) != 'X') return false;
                
                // 대각선
                if (isPerson(place, r - 1, c - 1)
                   && (place[r - 1].charAt(c) != 'X'
                   || place[r].charAt(c - 1) != 'X')) return false;
                if (isPerson(place, r - 1, c + 1)
                   && (place[r - 1].charAt(c) != 'X'
                   || place[r].charAt(c + 1) != 'X')) return false;
                if (isPerson(place, r + 1, c - 1)
                   && (place[r + 1].charAt(c) != 'X'
                   || place[r].charAt(c - 1) != 'X')) return false;
                if (isPerson(place, r + 1, c + 1)
                   && (place[r + 1].charAt(c) != 'X'
                   || place[r].charAt(c + 1) != 'X')) return false;
            }
        }
        
        return true;
    }
    
    private boolean isPerson(String[] place, int r, int c) {
        if (r < 0 || r >= 5 || c < 0 || c >= 5) return false;
        
        return place[r].charAt(c) == 'P';
    }
}
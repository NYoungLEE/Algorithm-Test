import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        int[] times = new int[timetable.length];
        for (int i = 0; i < times.length; i++) {
            String[] tt = timetable[i].split(":");
            times[i] = Integer.parseInt(tt[0]) * 60 + Integer.parseInt(tt[1]);
        }
        Arrays.sort(times);
        
        int idx = 0; int busTime = 540;
        for (int i = 0; i < n; i++) {
            int cnt = 0; int lastCrew = -1;
            
            while (idx < times.length) {
                if (times[idx] > busTime || cnt == m) break;
                
                lastCrew = times[idx];
                idx++; cnt++;
            }
            
            if (i == n - 1) {
                if (cnt < m) {
                    return format(busTime);
                } else {
                    return format(lastCrew - 1);
                }
            }
            
            busTime += t;
        }
        
        return "";
    }
    
    private String format(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}
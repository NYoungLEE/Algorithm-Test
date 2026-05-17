class Solution {
    
    public static final int SATURDAY = 6;
    public static final int SUNDAY = 7;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) {   
            
            int day = startday;
            boolean success = true;
            
            for (int j = 0; j < timelogs[i].length; j++) {

                if (day != SATURDAY && day != SUNDAY) {

                    int limitTime = addMinutes(schedules[i], 10);

                    if (timelogs[i][j] > limitTime) {
                        success = false;
                        break;
                    }
                }
                
                day++;
                if (day > 7) day = 1;
            }
            
            if (success) answer++;
        }
        
        return answer;
    }
    
    private int addMinutes(int time, int minutes) {
        int hour = time / 100;
        int minute = time % 100;
        
        minute += minutes;
        
        hour += minute / 60;
        minute %= 60;
        
        return hour * 100 + minute;
    }
}
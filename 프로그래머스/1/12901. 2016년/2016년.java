class Solution {
    public String solution(int a, int b) {

        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int cnt = 0;
        for (int i = 0; i < a - 1; i++) {
            cnt += days[i];
        }
        cnt += b - 1;
        
        return week[cnt % 7];
    }
}
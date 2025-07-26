class Solution {
    public int solution(int[][] dots) {
        
        int w = 0; int h = 0;
        int x = dots[0][0];
        int y = dots[0][1];
        
        for(int i = 0; i < dots.length; i++) {
            if(x != dots[i][0]) w = Math.abs(dots[i][0] - x);
            if(y != dots[i][1]) h = Math.abs(dots[i][1] - y);
        }
        
        return w * h;
        
    }
}
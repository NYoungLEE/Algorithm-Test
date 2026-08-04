  class Solution {
    public long solution(int r1, int r2) {
        
        long answer = 0;
        
        for (int x = 1; x <= r2 ; x++) {
            
            double minY = x <= r1 ? getY(x, r1) : 0;
            
            double maxY = getY(x, r2);
            
            answer += (long) (Math.floor(maxY) - Math.ceil(minY) + 1) ;
        }
        
        return answer * 4;
    }
   
    private double getY(long x, long r) {
        long gap = (r * r) - (x * x);
        return Math.sqrt(gap);
    }
}
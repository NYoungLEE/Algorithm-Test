class Solution {
    public long solution(int w, int h) {
        
        long entire = (long) w * h;        
        long partial = w + h - gcd(w, h);
        
        return entire - partial; 
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
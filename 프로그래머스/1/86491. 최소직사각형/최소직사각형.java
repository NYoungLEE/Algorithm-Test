class Solution {
    public int solution(int[][] sizes) {
        
        int max = 0;
        int min = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int tMax = Math.max(sizes[i][1], sizes[i][0]);
            int tMin = Math.min(sizes[i][1], sizes[i][0]);
            
            max = Math.max(tMax, max);
            min = Math.max(tMin, min);
        }
        
        return max * min;
    }
}
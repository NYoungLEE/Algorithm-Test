class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1;
        long max = 0;
        for (int num : times) max = Math.max(max, num);
        long right = max * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long time = process(mid, times);
            if (time >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return right + 1;
    }
    
    private long process(long num, int[] times) {
        long sum = 0; 
        
        for (int time : times) sum += num / time;
        
        return sum;
    }
}
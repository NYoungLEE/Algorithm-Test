class Solution {
    public int solution(int[] cookie) {
        
        int answer = 0;
        
        for (int m = 1; m < cookie.length; m++) {
            int l = m - 1;
            int r = m;
            int left = cookie[l];
            int right = cookie[r];
            
            while (true) {
                if (left == right) {
                    answer = Math.max(answer, left);
                }
                
                if (left <= right && l > 0) {
                    left += cookie[--l];
                } else if (left >= right && r < cookie.length - 1) {
                    right += cookie[++r];
                } else break;
            }
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int n, int w, int num) {
        
        int height = n / w + 1;
        int[][] arr = new int[height][w];
        
        int count = 1;
        int col = 0; int row = 0;
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if (count > n) break;
                    
                    if (count == num) {
                        col = i;
                        row = j;
                    }
                    
                    arr[i][j] = count++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    if (count > n) break;
                    
                    if (count == num) {
                        col = i;
                        row = j;
                    }
                    
                    arr[i][j] = count++;
                }
            }
        }
        
        int answer = 0;
        for (int i = col; i < height; i++) {
            if (arr[i][row] == 0) break;
            answer++;
        }
        
        return answer;
    }
}
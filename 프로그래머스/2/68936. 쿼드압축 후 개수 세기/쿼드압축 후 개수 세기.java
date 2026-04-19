class Solution {
    
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void compress(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    int half = size / 2;
                    compress(arr, x, y, half);
                    compress(arr, x, y + half, half);
                    compress(arr, x + half, y, half);
                    compress(arr, x + half, y + half, half);
                    return;
                }
            }
        }

        answer[value]++;
    }
}
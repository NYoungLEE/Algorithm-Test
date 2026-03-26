class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 3; i < sum / 2; i++) {
            if (sum % i == 0) {
                int width = sum / i;
                int length = i;
                
                if (brown == 2 * (width + length - 2)) {
                    answer[0] = width;
                    answer[1] = length;
                    break;
                }
            }    
        }
        
        return answer;
    }
}
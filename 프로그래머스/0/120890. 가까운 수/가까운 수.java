class Solution {
    public int solution(int[] array, int n) {
        
        int near = Math.abs(array[0] - n);
        int answer = array[0];
        
        for(int i = 0; i < array.length; i++) {
            int num = Math.abs(array[i] - n);
            
            if(num < near) {
                near = num;
                answer = array[i];
            } else if (num == near && array[i] < answer) {
                answer = array[i];
            }
        }

        return answer;
    }
}
class Solution {
    public int[] solution(int[] array) {
        
        int[] answer = new int[2];
        int max = array[0];
        int count = 0;
        
        for(int i = 0; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
            if(max == array[i]) count = i;
        }
        
        answer[0] = max;
        answer[1] = count;
        
        return answer;
    }
}
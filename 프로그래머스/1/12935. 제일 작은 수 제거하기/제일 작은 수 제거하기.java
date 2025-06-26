class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) return new int[] {-1};
        
        int min = arr[0];
        int count = 0;
        
        for (int num : arr) {
            min = Math.min(min, num);
        }
        
        int[] answer = new int[arr.length - 1];
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) continue;
            answer[count++] = arr[i];
        }
        
        return answer;
    }
}
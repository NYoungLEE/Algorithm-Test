class Solution {
    public int[] solution(long n) {
        
        String[] arr = Long.toString(n).split("");
        int[] answer = new int[arr.length];
        
        int size = answer.length;
        for (int i = 0; i < size; i++) {
            answer[i] = Integer.parseInt(arr[size - i - 1]);
        }
        
        return answer;
    }
}
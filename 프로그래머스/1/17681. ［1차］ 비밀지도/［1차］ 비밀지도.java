class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int idx = 0;
        for (int i = 0; i < arr1.length; i++) {
            String temp = String.format("%" + n + "s", 
                                        Integer.toString(arr1[i] | arr2[i], 2))
                .replace(' ', '0');
            temp = temp.replace('1', '#');
            temp = temp.replace('0', ' ');
            answer[idx++] = temp;
        }
        
        return answer;
    }
}
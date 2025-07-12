class Solution {
    public String[] solution(String[] quiz) {
        
        String[] answer = new String[quiz.length];
        int pos = 0;
        
        for(String s : quiz) {
            String[] arr = s.split(" ");
            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[2]);
            int num = Integer.parseInt(arr[4]);
            
            if(arr[1].equals("+")){
                answer[pos++] = (num1 + num2 == num) ? "O" : "X";
            } else {
                answer[pos++] = (num1 - num2 == num) ? "O" : "X";
            }
        } 
        
        return answer;
    }
}
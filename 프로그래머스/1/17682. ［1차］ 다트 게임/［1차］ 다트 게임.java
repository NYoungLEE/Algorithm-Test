class Solution {
    public int solution(String dartResult) {

        int[] score = new int[3];
        String number = "";
        int idx = 0;

        for(char ch : dartResult.toCharArray()) {
            
            if (Character.isDigit(ch)) {
                number += ch;
            } else if (ch == 'S' || ch == 'D' || ch == 'T') {
                
                int n = Integer.parseInt(number);
                number = "";
                
                if (ch == 'S') score[idx] = n;
                else if (ch == 'D') score[idx] = (int) Math.pow(n, 2);
                else score[idx] = (int) Math.pow(n, 3);
                
                idx++;
            } else if (ch == '*') {
                score[idx - 1] *= 2;
                if (idx > 1) score[idx - 2] *= 2;
            } else if (ch == '#') {
                score[idx - 1] = -score[idx - 1];
            }
        }
        
        int answer = score[0] + score[1] + score[2];
        return answer;
    }
}
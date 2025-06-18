class Solution {
    public String solution(int age) {
        
        // 풀이 1
        StringBuilder sb = new StringBuilder();
        String ageStr = String.valueOf(age);
        
        for (int i = 0; i < ageStr.length(); i++) {
            sb.append((char)(ageStr.charAt(i) - '0' + 'a'));
        }
        
        return sb.toString();
        
        /* 풀이 2
        String answer = "";
        String age962 = "abcdefghij";
        String[] ageArr = String.valueOf(age).split("");
        
        for (int i = 0; i < ageArr.length; i++) {
            answer += age962.charAt(Integer.valueOf(ageArr[i]));
        }
        
        return answer; */
        
        /* 풀이 3
        String answer = "";
        char[] age962 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        String ageStr = String.valueOf(age);
        
        for (int i = 0; i < ageStr.length(); i++) {
            int digit = Character.getNumericValue(ageStr.charAt(i));
            answer += age962[digit];
        }
        
        return answer; */
    }
}
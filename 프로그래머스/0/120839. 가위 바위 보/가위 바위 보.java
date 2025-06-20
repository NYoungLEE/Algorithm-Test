class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        String[] rspArr = rsp.split("");
        
        for (int i = 0; i < rspArr.length; i++) {
            switch(rspArr[i]) {
                case "2" : answer += "0"; break;
                case "0" : answer += "5"; break;
                case "5" : answer += "2"; break;    
            }
        }
        
        return answer;
    }
}
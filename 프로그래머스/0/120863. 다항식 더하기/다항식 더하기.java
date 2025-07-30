class Solution {
    public String solution(String polynomial) {
        
        String[] arr = polynomial.split(" ");
        int xNum = 0; int num = 0;
        
        for (String str : arr) {
            if(str.contains("x")) {
                xNum += (str.equals("x")) ? 1 : Integer.parseInt(str.replaceAll("x", ""));
            } else if(!str.equals("+")) {
                num += Integer.parseInt(str);
            }
        }
        
        String answer = (xNum == 0 ? "" : xNum == 1 ? "x" : xNum + "x") 
            + (xNum != 0 && num != 0 ? " + " : "")
            + (num == 0 ? "" : num);
        return answer;
    }
}
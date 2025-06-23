class Solution {
    public String solution(String my_string) {
        
        String[] str = my_string.split("");
        StringBuilder sb = new StringBuilder();
        
        for (String n : str) {
            if(n.equals("a") || n.equals("e") || n.equals("i") ||
              n.equals("o") || n.equals("u")) continue;
            sb.append(n);
        }
            
        return sb.toString();
    }
}
class Solution {
    public String solution(String my_string) {
        
        /* 풀이 1
        String[] str = my_string.split("");
        StringBuilder sb = new StringBuilder();
        
        for (String n : str) {
            if(n.equals("a") || n.equals("e") || n.equals("i") ||
              n.equals("o") || n.equals("u")) continue;
            sb.append(n);
        }
            
        return sb.toString(); */
        
        StringBuilder sb = new StringBuilder();
        
        /* 풀이2
        for (char c : my_string.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        
        return sb.toString(); */
        
        // 풀이3
        return my_string.replaceAll("[aeiou]", "");
    }
}
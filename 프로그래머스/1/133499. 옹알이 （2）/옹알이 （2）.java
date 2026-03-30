class Solution {
    public int solution(String[] babbling) {
        
        int answer = 0;
        
        for (String str : babbling) {
            int idx = 0;
            String next = "";
            while (idx < str.length()) {
                if (str.startsWith("aya", idx) && !next.equals("aya")) {
                    idx += 3;
                    next = "aya";
                } else if (str.startsWith("ye", idx) && !next.equals("ye")) {
                    idx += 2;
                    next = "ye";
                } else if (str.startsWith("woo", idx) && !next.equals("woo")) {
                    idx += 3;
                    next = "woo";
                } else if (str.startsWith("ma", idx) && !next.equals("ma")) {
                    idx += 2;
                    next = "ma";
                } else {
                    break;
                }
            }
            if (idx == str.length()) answer++;
        }
        
        return answer;
    }
}
class Solution {
    public int solution(String t, String p) {
        
        int len = p.length();
        long pNum = Long.parseLong(p);
        int count = 0;
        
        for (int i = 0; i < t.length() - len + 1; i++) {
            String str = t.substring(i, i + len);
            if (Long.parseLong(str) <= pNum) count++;
        }
        
        return count;
    }
}
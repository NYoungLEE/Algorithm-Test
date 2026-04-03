class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] sArr = Integer.toString(n, k).split("0");
        
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals("")) continue;
            long num = Long.parseLong(sArr[i]);
            if (isPrime(num)) answer++;
        }
        
        
        return answer;
    }
    
    private boolean isPrime(long n) {
        
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
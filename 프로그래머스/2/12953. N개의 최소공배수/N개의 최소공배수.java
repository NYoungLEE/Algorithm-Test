class Solution {
    public int solution(int[] arr) {
        
        int answer = arr[0];
        
        for(int num : arr) {
            int gcd = gcd(answer, num);
            answer *= num / gcd;
        }
        
        return answer;
    }
    
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}


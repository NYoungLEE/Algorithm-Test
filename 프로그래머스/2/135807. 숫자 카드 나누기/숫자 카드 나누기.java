class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);

        int answer = 0;
        if (!canDivide(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }
        if (!canDivide(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    private int getGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    private boolean canDivide(int gcd, int[] arr) {
        for (int num : arr) {
            if (num % gcd == 0) return true;
        }
        return false;
    }
}
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int temp = storey % 10;
            
            if (temp > 5) {
                answer += 10 - temp;
                storey += 10;
            } else if (temp < 5) {
                answer += temp;
            } else {
                if ((storey / 10) % 10 >= 5) {
                    answer += 5;
                    storey += 10;
                } else {
                    answer += 5;
                }
            }
            storey /= 10;
        }
        
        return answer;
    }
}
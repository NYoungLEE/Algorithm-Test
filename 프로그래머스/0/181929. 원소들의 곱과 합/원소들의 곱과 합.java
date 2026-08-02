class Solution {
    public int solution(int[] num_list) {
        
        int mul = 1; int plus = 0;
        
        for (int num : num_list) {
            mul *= num;
            plus += num;
        }

        return Math.pow(plus, 2) > mul ? 1: 0;
    }
}
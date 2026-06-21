import java.util.*;

class Solution {
    public long solution(String expression) {
        
        List<Long> numbers = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        
        parse(expression, numbers, operations);
        
        char[][] priorities = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };
        
        long answer = 0;
        
        for (char[] priority : priorities) {
            
            List<Long> nums = new ArrayList<>(numbers);
            List<Character> ops = new ArrayList<>(operations);
            
            for (char op : priority) {
                for (int i = 0; i < ops.size(); ) {
                    if (ops.get(i) == op) {
                        long result = calculate(nums.get(i), nums.get(i + 1), op);
                        
                        nums.remove(i);
                        nums.remove(i);
                        nums.add(i, result);
                        ops.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(nums.get(0)));
        }
        
        return answer;
    }
    
    private void parse(String expression, List<Long> nums, List<Character> ops) {
        
        StringBuilder sb = new StringBuilder();
        
        for (char ch : expression.toCharArray()) {
            
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                
                ops.add(ch);
            }
        }
        
        nums.add(Long.parseLong(sb.toString()));
    }
    
    private long calculate(long a, long b, char op) {
        
        switch (op) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            default:
                throw new IllegalArgumentException();
        }
    }
}
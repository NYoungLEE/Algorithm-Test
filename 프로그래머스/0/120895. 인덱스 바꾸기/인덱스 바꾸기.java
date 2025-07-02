import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        
        // 풀이1
        char[] arr = my_string.toCharArray();
        
        char temp = arr[num2];
        arr[num2] = arr[num1];
        arr[num1] = temp; 
        
        return new String(arr);
        
        /* 풀이2
        List<String> list = new ArrayList<>(List.of(my_string.split("")));
        
        Collections.swap(list, num1, num2);
        
        return String.join("", list); */
    }
}
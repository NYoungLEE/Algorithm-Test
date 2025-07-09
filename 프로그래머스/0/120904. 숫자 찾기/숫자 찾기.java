class Solution {
    public int solution(int num, int k) {
        
        String number = Integer.toString(num);
        String[] arr = number.split("");
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(Integer.toString(k))) return (i + 1);
        }
        
        return -1;

    }
}
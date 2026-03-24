class Solution {
    public String solution(String s) {
        
        String[] arr = s.split(" ");
        int[] num = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        
        int min = num[0];
        int max = num[0];
        for (int n : num) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        return min + " " + max;
    }
}
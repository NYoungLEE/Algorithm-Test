import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (a, b) -> {
            int idxA = 0;
            int idxB = 0;
            
            while (!Character.isDigit(a.charAt(idxA))) idxA++;
            while (!Character.isDigit(b.charAt(idxB))) idxB++;
            
            String headA = a.substring(0, idxA).toLowerCase();
            String headB = b.substring(0, idxB).toLowerCase();
            
            int headCompare = headA.compareTo(headB);
            if (headCompare != 0) return headCompare;
            
            int startA = idxA;
            int startB = idxB;
            
            while (idxA < a.length() && Character.isDigit(a.charAt(idxA))) idxA++;
            while (idxB < b.length() && Character.isDigit(b.charAt(idxB))) idxB++;
            
            int numA = Integer.parseInt(a.substring(startA, idxA));
            int numB = Integer.parseInt(b.substring(startB, idxB));
            
            return numA - numB;
        });
        
        return files;
    }
}
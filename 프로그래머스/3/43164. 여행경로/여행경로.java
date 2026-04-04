import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<String> path = new ArrayList<>();
    static String[][] tickets;
    static boolean found = false;
    
    public String[] solution(String[][] ticketsInput) {
        tickets = ticketsInput;
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        dfs(0, "ICN");
        return path.toArray(new String[0]);
    }
    
    private void dfs(int depth, String airport) {
        path.add(airport);
        
        if (depth == tickets.length) {
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (airport.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1]);
                if (found) return;
                visited[i] = false;
            }
        }
        
        path.remove(path.size() - 1);
    }
}
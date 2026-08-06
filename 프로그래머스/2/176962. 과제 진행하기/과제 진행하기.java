import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (String[] plan : plans) {
            pq.offer(new Task(plan[0], toMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        
        Stack<Task> stop = new Stack<>();
        List<String> end = new ArrayList<>();
        
        Task now = pq.poll();
        int time = now.start;
        while (!pq.isEmpty()) {
            time += now.left;
            Task next = pq.peek();
            
            if (time > next.start) {
                now.left = time - next.start;
                stop.push(now);
            } else {
                end.add(now.name);
                if (!stop.isEmpty()) {
                    now = stop.pop();
                    continue;
                }
            }
            
            now = pq.poll();
            time = now.start;
        }
        
        end.add(now.name);
        while (!stop.isEmpty()) {
            end.add(stop.pop().name);
        }
        
        return end.toArray(new String[0]);
        
    }
    
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public static class Task implements Comparable<Task> {
        String name;
        int start;
        int left;
        
        public Task(String name, int start, int left) {
            this.name = name;
            this.start = start;
            this.left = left;
        }
        
        public int compareTo(Task t) {
            return this.start - t.start;
        }
    }
}
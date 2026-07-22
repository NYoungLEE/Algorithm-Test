import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int limit = Math.min(minerals.length, Arrays.stream(picks).sum() * 5);
        
        List<Group> groups = new ArrayList<>();
        
        for (int i = 0; i < limit; i += 5) {
            int dia = 0; int iron = 0; int stone = 0;
            
            int end = Math.min(i + 5, limit);
            
            for (int j = i; j < end; j++) {
                if (minerals[j].equals("diamond")) dia++;
                else if (minerals[j].equals("iron")) iron++;
                else stone++;
            }
            
            int weight = dia * 25 + iron * 5 + stone;
            groups.add(new Group(dia, iron, stone, weight));
        }
        
        groups.sort((a, b) -> b.weight - a.weight);
        
        int answer = 0;
        for (Group g : groups) {
            if (picks[0] >= 1) {
                answer += (g.diamond + g.iron + g.stone);
                picks[0]--;
            } else if (picks[1] >= 1) {
                answer += (g.diamond * 5 + g.iron + g.stone);
                picks[1]--;
            } else {
                answer += (g.diamond * 25 + g.iron * 5 + g.stone);
                picks[2]--;
            }
        }
        
        return answer;

    }
    

    public static class Group {
        int diamond;
        int iron;
        int stone;
        int weight;

        public Group (int diamond, int iron, int stone, int weight) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
            this.weight = weight;
        }
    }
}
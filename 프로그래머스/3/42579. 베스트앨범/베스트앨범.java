import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> list = new ArrayList<>();
        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[] {i, plays[i]});
            
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreList = new ArrayList<>(total.keySet());
        genreList.sort((a, b) -> total.get(b) - total.get(a));
        
        for (String genre : genreList) {
            List<int[]> playList = map.get(genre);
            playList.sort((a, b) -> b[1] - a[1]);
            
            for (int i = 0; i < Math.min(2, playList.size()); i++) {
                list.add(playList.get(i)[0]);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
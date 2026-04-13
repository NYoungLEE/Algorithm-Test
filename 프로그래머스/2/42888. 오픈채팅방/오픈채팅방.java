import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();
        for (String str : record) {
            String[] sArr = str.split(" ");
            if(sArr[0].equals("Enter")) {
                nickname.put(sArr[1], sArr[2]);
            } else if (sArr[0].equals("Change")) {
                nickname.put(sArr[1], sArr[2]);
            }
        }
        
        for (String str : record) {
            String[] sArr = str.split(" ");
            if(sArr[0].equals("Enter")) {
                list.add(nickname.get(sArr[1]) + "님이 들어왔습니다.");
            } else if (sArr[0].equals("Leave")) {
                list.add(nickname.get(sArr[1]) + "님이 나갔습니다.");
            }
        }
        
        
        return list.toArray(new String[0]);
    }
}
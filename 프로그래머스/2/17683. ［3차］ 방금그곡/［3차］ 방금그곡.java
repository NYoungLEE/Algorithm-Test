class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int maxTime = -1;
        
        m = convert(m);
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            
            int start = toMinute(info[0]);
            int end = toMinute(info[1]);
            int playTime = end - start;
            
            String title = info[2];
            String melody = convert(info[3]);

            StringBuilder played = new StringBuilder();
            for (int j = 0; j < playTime; j++) {
                played.append(melody.charAt(j % melody.length()));
            }
            
            if (played.toString().contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            } 
        }

        return answer;
    }
    
    private String convert(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
    
    private int toMinute(String time) {
        String[] sArr = time.split(":");
        int hour = Integer.parseInt(sArr[0]);
        int minute = Integer.parseInt(sArr[1]);
        return hour * 60 + minute;
    }
}
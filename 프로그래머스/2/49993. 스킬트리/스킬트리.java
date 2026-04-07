class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            int idx = 0;
            boolean valid = true;

            for (char ch : tree.toCharArray()) {
                if (skill.indexOf(ch) != -1) {
                    if (idx < skill.length() && skill.charAt(idx) == ch) {
                        idx++;
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            
            if (valid) answer++;
        }
        
        return answer;
    }
}
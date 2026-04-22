class Solution {
    public String solution(String new_id) {
        String id = new_id;

        // 1단계
        id = id.toLowerCase();

        // 2단계
        id = id.replaceAll("[^a-z0-9-_.]", "");

        // 3단계
        id = id.replaceAll("\\.{2,}", ".");

        // 4단계
        id = id.replaceAll("^\\.|\\.$", "");

        // 5단계
        if (id.isEmpty()) id = "a";

        // 6단계
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            id = id.replaceAll("\\.$", "");
        }

        // 7단계
        while (id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }

        return id;
    }
}
import java.util.*;

class Solution {

    public List<Set<Integer>> keys = new ArrayList<>();

    public int solution(String[][] relation) {

        int cnt = relation[0].length;

        for (int size = 1; size <= cnt; size++) {
            dfs(0, size, new ArrayList<>(), relation);
        }

        return keys.size();
    }

    private void dfs(
            int start,
            int size,
            List<Integer> list,
            String[][] relation
    ) {

        if (list.size() == size) {
            check(list, relation);
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            list.add(i);
            dfs(i + 1, size, list, relation);
            list.remove(list.size() - 1);
        }
    }

    private void check(List<Integer> list, String[][] relation) {

        // 1. 유일성 검사
        Set<String> set = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j : list) {
                sb.append(relation[i][j]).append("|");
            }

            if (!set.add(sb.toString())) {
                return;
            }
        }

        // 2. 최소성 검사
        for (Set<Integer> key : keys) {

            if (list.containsAll(key)) {
                return;
            }
        }

        // 3. 후보키 등록
        keys.add(new HashSet<>(list));
    }
}
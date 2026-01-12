import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static int[] trueP;
  public static ArrayList<Integer>[] party;
  public static int[] parent;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 사람 수
    int M = sc.nextInt(); // 파티 수
    int T = sc.nextInt();  // 진실을 아는 사람 정보
    trueP = new int[T];
    for (int i = 0; i < T; i++) {
      trueP[i] = sc.nextInt();
    }
    party = new ArrayList[M];
    for (int i = 0; i < M; i++) {
      party[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      int size = sc.nextInt();
      for (int j = 0; j < size; j++) {
        party[i].add(sc.nextInt());
      }
    }
    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      int first = party[i].get(0);
      for (int j = 1; j < party[i].size(); j++) {
        union(first, party[i].get(j));
      }
    }

    int result = 0;
    for (int i = 0; i < M; i++) {
      boolean isPossible = true;
      int cur = party[i].get(0);
      for (int k : trueP) {
        if (find(cur) == find(k)) {
          isPossible = false;
          break;
        }
      }
      if (isPossible) result++;
    }
    System.out.println(result);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
}

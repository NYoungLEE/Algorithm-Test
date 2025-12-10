import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Integer>[] A;
  static boolean[] visited;
  static int count;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int C = Integer.parseInt(st.nextToken()); // 컴퓨터의 수
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 컴퓨터 쌍의 수

    A = new ArrayList[C + 1];
    visited = new boolean[C + 1];
    for (int i = 1; i < C + 1; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E);
      A[E].add(S);
    }

    count = 0;
    DFS(1);

    System.out.println(count);
  }

  public static void DFS(int num) {
    visited[num] = true;

    for (int i : A[num]) {
      if (!visited[i]) {
        count++;
        DFS(i);
      }
    }
  }
}
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 유저의 수
    int M = sc.nextInt(); // 친구 관계의 수
    int[][] distance = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == j) distance[i][j] = 0;
        else distance[i][j] = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < M; i++) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      distance[A][B] = 1;
      distance[B][A] = 1;
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
          distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int answer = -1;
    for (int i = 1; i <= N; i++) {
      int tmp = 0;
      for (int j = 1; j <= N; j++) {
        tmp += distance[i][j];
      }
      if (min > tmp) {
        min = tmp;
        answer = i;
      }
    }
    System.out.println(answer);
  }
}

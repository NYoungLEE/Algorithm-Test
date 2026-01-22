import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // a의 개수
    int M = sc.nextInt(); // z의 개수
    int K = sc.nextInt();
    int[][] D = new int[201][201];
    for (int i = 0; i <= 200; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i)
          D[i][j] = 1;
        else {
          D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
          if (D[i][j] > 1000000000) D[i][j] = 1000000000;
        }
      }
    }
    if (D[N + M][M] < K)
      System.out.println(-1);
    else {
      while (!(N == 0 && M == 0)) {
        if (D[N - 1 + M][M] >= K) {
          System.out.print("a");
          N--;
        } else {
          System.out.print("z");
          K -= D[N - 1 + M][M];
          M--;
        }
      }
    }
  }
}

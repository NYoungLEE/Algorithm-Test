import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int[][] D = new int[15][15];
    for (int i = 0; i < 15; i++) {
      D[i][1] = 1;
      D[0][i] = i;
    }
    for (int i = 1; i < 15; i++) {
      for (int j = 2; j < 15; j++) {
        D[i][j] = D[i][j - 1] + D[i - 1][j];
      }
    }

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 질의 수
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt(); // 층
      int K = sc.nextInt(); // 호
      System.out.println(D[N][K]);
    }
  }
}
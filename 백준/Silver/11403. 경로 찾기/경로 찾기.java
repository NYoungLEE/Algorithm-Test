import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 인접 행렬의 크기
    int[][] distance = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        distance[i][j] = sc.nextInt();
      }
    }
    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (distance[i][k] == 1 && distance[k][j] == 1)
            distance[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(distance[i][j] + " ");
      }
      System.out.println();
    }
  }
}

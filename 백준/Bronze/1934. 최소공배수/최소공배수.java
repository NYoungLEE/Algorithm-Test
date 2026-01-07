import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 케이스 개수
    for (int i = 0; i < T; i++) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      int result = 0;
      if (A < B) {
        result = A * B / GCD(B, A);
      } else {
        result = A * B / GCD(A, B);
      }
      System.out.println(result);
    }
  }

  private static int GCD(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    } else {
      return GCD(num2, num1 % num2);
    }
  }
}
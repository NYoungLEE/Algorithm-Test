import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong(); // 소인수
    long result = N;  // 결과값

    for (long p = 2; p * p <= N; p++) {
      if (N % p == 0) {
        result -= result / p;
        while (N % p == 0) {
          N /= p;
        }
      }
    }

    if (N > 1) {
      result -= result / N;
    }

    System.out.println(result);
  }
}

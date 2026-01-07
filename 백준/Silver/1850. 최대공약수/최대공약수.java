import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long A = sc.nextLong(); // 첫번째 수
    long B = sc.nextLong(); // 두번째 수
    long result = GCD(A, B);
    while (result > 0) {
      bw.write("1");
      result--;
    }
    bw.flush();
    bw.close();
  }

  private static long GCD(long num1, long num2) {
    if (num2 == 0) {
      return num1;
    } else {
      return GCD(num2, num1 % num2);
    }
  }
}
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long Min = sc.nextLong();
    long Max = sc.nextLong();
    boolean[] check = new boolean[(int) (Max - Min + 1)];
    for (long i = 2; i * i <= Max; i++) {
      long pow = i * i;
      long start = Min / pow;
      if (Min % pow != 0) start++;
      for (long j = start; pow * j <= Max; j++) {
        check[(int) (pow * j - Min)] = true;
      }
    }

    int count = 0;
    for (int i = 0; i < check.length; i++) {
      if (!check[i]) {
        count++;
      }
    }
    System.out.println(count);
  }
}

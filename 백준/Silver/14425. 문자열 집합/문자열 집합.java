import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    tNode root = new tNode();
    while (N > 0) {
      String text = sc.next();
      tNode now = root;
      for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        if (now.next[ch - 'a'] == null) {
          now.next[ch - 'a'] = new tNode();
        }
        now = now.next[ch - 'a'];
        if (i == text.length() - 1) now.isEnd = true;
      }
      N--;
    }

    int count = 0;
    while (M > 0) {
      String text = sc.next();
      tNode now = root;
      for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        if (now.next[ch - 'a'] == null) {
          break;
        }
        now = now.next[ch - 'a'];
        if (i == text.length() - 1 && now.isEnd) count++;
      }
      M--;
    }

    System.out.println(count);

  }
}

class tNode {
  tNode[] next = new tNode[26];
  boolean isEnd;
}

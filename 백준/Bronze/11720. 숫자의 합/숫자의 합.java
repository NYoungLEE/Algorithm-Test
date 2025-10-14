import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for(int i = 0; i < count; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum); 
    }
}
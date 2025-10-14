import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] score = new int[num];
        for(int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }

        long max = 0;
        long sum = 0;
        for(int i = 0; i < num; i++) {
            max = score[i] > max ? score[i] : max;
            sum += score[i];
        }

        sc.close();

        System.out.println(sum * 100.0 / max / num);
    }

}
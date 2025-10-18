import java.io.*;
import java.util.*;

public class Main {

    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 수의 개수
        A = new int[N + 1];
        tmp = new int[N + 1];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        result = 0;
        mergeSort(1, N);
        System.out.println(result);
    }

    private static void mergeSort(int S, int E) {
        if(E- S < 1) return;

        int M = S + (E - S) / 2;
        mergeSort(S, M);
        mergeSort(M + 1, E);
        for (int i = S; i <= E; i++) {
            tmp[i] = A[i];
        }

        int K = S;
        int index1 = S;
        int index2 = M + 1;
        while (index1 <= M && index2 <= E) {
            if (tmp[index1] <= tmp[index2]) {
                A[K++] = tmp[index1++];
            } else {
                A[K++] = tmp[index2++];
                result += (M - index1) + 1;
            }
        }

        while (index1 <= M) {
            A[K++] = tmp[index1++];
        }
        while (index2 <= E) {
            A[K++] = tmp[index2++];
        }
    }
}

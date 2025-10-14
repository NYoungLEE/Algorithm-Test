import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        long[] S = new long[subNo + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= subNo; i++){
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < quizNo; j++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            System.out.println(S[b] - S[a - 1]);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static boolean[] visited;
    public static ArrayList<Integer>[] A;
    public static boolean arrive;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   // 노드 개수
        int M =  Integer.parseInt(st.nextToken());  // 에지 개수
        visited = new boolean[N];
        A = new ArrayList[N];
        arrive = false;
        
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        
    }
    
    private static void DFS (int num, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[num] = true;
        for (int i : A[num]) {
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[num] = false;
    }
}

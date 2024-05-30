package BaekJoon.Gold4.가장가까운공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3584 {

    static int T, N;
    static int[] parent;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int a = 0; a < T; a++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            compute(c1, c2);
        }
    }

    static void compute(int c1, int c2) {
        while (c1 > 0) {
            visited[c1] = true;
            c1 = parent[c1];
        }

        while (c2 > 0) {
            if (visited[c2]) {
                System.out.println(c2);
                break;
            }
            c2 = parent[c2];
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ3584.solution();
    }
}

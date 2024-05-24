package BaekJoon.Gold4.키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2458 {

    static int N, M;
    static int result = 0;
    static ArrayList<Integer>[][] list;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[2][N + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= N; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[0][s].add(e);
            list[1][e].add(s);
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int taller = compute(0, i);
            int smaller = compute(1, i);
            if (taller + smaller - 2 == N - 1) {
                result++;
            }
        }
        System.out.println(result);
    }

    static int compute(int k, int e) {
        int cnt = 1;
        visited[e] = true;
        for (int next : list[k][e]) {
            if (!visited[next]) {
                cnt += compute(k, next);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BOJ2458.solution();
    }
}

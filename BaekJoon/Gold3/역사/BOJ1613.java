package BaekJoon.Gold3.역사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1613 {

    static int N, K, S;
    static boolean[][] event;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        event = new boolean[N + 1][N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            event[s][e] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (event[j][i]&& event[i][k]) {
                        event[j][k] = true;
                    }
                }
            }
        }
        S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (event[a][b]) {
                System.out.println(-1);
            } else if (event[b][a]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1613.solution();
    }
}

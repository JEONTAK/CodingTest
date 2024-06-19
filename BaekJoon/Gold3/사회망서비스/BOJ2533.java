package BaekJoon.Gold3.사회망서비스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2533 {

    static int N;
    static ArrayList<Integer>[] list;
    static int[][] dp;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        compute(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void compute(int num) {
        visited[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        for (int next : list[num]) {
            if (!visited[next]) {
                compute(next);
                dp[num][0] += dp[next][1];
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2533.solution();
    }
}

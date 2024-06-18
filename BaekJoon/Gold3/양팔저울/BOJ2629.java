package BaekJoon.Gold3.양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2629 {

    static int N, M;
    static int[] weight;
    static boolean[][] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        dp = new boolean[N + 1][40001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        compute(0, 0);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int T = Integer.parseInt(st.nextToken());
            if (dp[N][T]) {
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }
        System.out.println(sb.toString());
    }

    static void compute(int cnt, int idx) {
        if(idx > 500 * 30 || dp[cnt][idx]) return;
        dp[cnt][idx] = true;
        if(cnt == N)return;

        compute(cnt + 1, idx + weight[cnt]);
        compute(cnt + 1, idx);
        compute(cnt + 1, Math.abs(idx - weight[cnt]));
    }
    public static void main(String[] args) throws IOException {
        BOJ2629.solution();
    }
}

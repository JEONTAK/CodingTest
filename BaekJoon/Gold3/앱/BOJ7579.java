package BaekJoon.Gold3.앱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7579 {

    static int N, M;
    static int[][] app, dp;
    static int result = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        app =new int[N][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                app[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][10001];

        for (int i = 0; i < N; i++) {
            int c = app[i][1];
            int m = app[i][0];

            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if(j >= c) dp[i][j] = m;
                }else{
                    if(j >= c) dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }
                if(dp[i][j] >= M) result = Math.min(result, j);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ7579.solution();
    }
}

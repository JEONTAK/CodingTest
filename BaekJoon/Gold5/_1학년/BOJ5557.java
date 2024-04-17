package BaekJoon.Gold5._1학년;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5557 {

    static int N;
    static int[] sequence;
    static int answer;
    static long[][] dp;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.parseInt(st.nextToken());
        //dp 0 = plus, 1 = minus
        dp[0][sequence[1]] = 1;
        int plus;
        int minus;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    plus = j + sequence[i + 1];
                    minus = j - sequence[i + 1];
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }

        }
        System.out.println(dp[N - 2][answer]);
    }

    public static void main(String[] args) throws IOException {
        BOJ5557.solution();
    }
}

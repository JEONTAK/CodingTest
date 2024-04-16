package BaekJoon.Gold5.퇴사2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15486 {

    static int N;
    static int[][] counseling;
    static int[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        counseling = new int [N + 2][2];
        dp = new int[N + 2];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            counseling[i][0] = Integer.parseInt(st.nextToken());
            counseling[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            int nIdx = i + counseling[i][0];
            if(nIdx < N + 2){
                dp[nIdx] = Math.max(dp[nIdx], max + counseling[i][1]);
            }
        }
        System.out.println(dp[N + 1]);
    }
    public static void main(String[] args) throws IOException {
        BOJ15486.solution();
    }
}

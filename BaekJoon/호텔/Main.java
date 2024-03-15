package BaekJoon.호텔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int C;
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C+100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost =  Integer.parseInt(st.nextToken());
            int customer =  Integer.parseInt(st.nextToken());

            for (int j = customer; j < C + 100; j++) {
                if (dp[j - customer] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - customer]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);

    }
}

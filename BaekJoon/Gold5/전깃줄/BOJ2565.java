package BaekJoon.Gold5.전깃줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {

    static int N;
    static int [][] wire;
    static Integer[] dp;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N];
        wire = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(compute(i), max);
        }
        System.out.println(N - max);
    }

    static int compute(int n){
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n + 1; i < dp.length; i++) {
                if (wire[n][1] < wire[i][1]) {
                    dp[n] = Math.max(dp[n], compute(i) + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BOJ2565.solution();
    }
}

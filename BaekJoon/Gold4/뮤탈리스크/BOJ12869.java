package BaekJoon.Gold4.뮤탈리스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12869 {

    static int N;
    static int[] SCV;
    static int[][] attack = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-9,-3},{-1,-3,-9}};
    static int[][][] dp;
    static int min = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        SCV = new int[3];
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[61][61][61];
        compute(SCV, 0);

        System.out.println(min);
    }

    static void compute(int[] scv, int idx) {
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];
        if(min <= idx) return;

        if(dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= idx)return;
        dp[s1][s2][s3] = idx;
        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, idx);
            return;
        }

        for (int i = 0; i < 6; i++) {
            compute(new int[] {Math.max(s1 + attack[i][0], 0),Math.max(s2 + attack[i][1], 0),Math.max(s3 + attack[i][2], 0)}, idx+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BOJ12869.solution();
    }
}

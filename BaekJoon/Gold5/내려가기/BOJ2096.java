package BaekJoon.Gold5.내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2096 {
    static int N;
    static int[][] puzzle;
    static int[] maxDp, minDp;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        puzzle = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxDp = new int[3];
        minDp = new int[3];
        maxDp[0] = minDp[0] = puzzle[0][0];
        maxDp[1] = minDp[1] = puzzle[0][1];
        maxDp[2] = minDp[2] = puzzle[0][2];
        for (int i = 1; i < N; i++) {
            int preMaxDp0 = maxDp[0], preMaxDp2 = maxDp[2];
            maxDp[0] = Math.max(maxDp[0], maxDp[1]) + puzzle[i][0];
            maxDp[2] = Math.max(maxDp[1], maxDp[2]) + puzzle[i][2];
            maxDp[1] = Math.max(Math.max(preMaxDp0,maxDp[1]), preMaxDp2) + puzzle[i][1];

            int preMinDp0 = minDp[0], preMinDp2 = minDp[2];
            minDp[0] = Math.min(minDp[0], minDp[1]) + puzzle[i][0];
            minDp[2] = Math.min(minDp[1], minDp[2]) + puzzle[i][2];
            minDp[1] = Math.min(Math.min(preMinDp0,minDp[1]), preMinDp2) + puzzle[i][1];
        }

        System.out.println(Math.max(maxDp[0],Math.max(maxDp[1],maxDp[2])) + " " + Math.min(minDp[0],Math.min(minDp[1],minDp[2])) );
    }

    public static void main(String[] args) throws IOException {
        BOJ2096.solution();
    }
}

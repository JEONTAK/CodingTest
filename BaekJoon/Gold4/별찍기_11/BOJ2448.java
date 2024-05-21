package BaekJoon.Gold4.별찍기_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2448 {

    static int N;
    static int W, H;
    static char[][] stars;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        H = N;
        W = N * 2 - 1;
        stars = new char[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            Arrays.fill(stars[i], ' ');
        }
        compute(H, W, N);
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void compute(int h, int w, int idx) {
        if (idx == 3) {
            stars[h - 2][w - 2] = '*';
            stars[h - 1][w - 3] = '*';
            stars[h - 1][w - 1] = '*';
            for (int i = w - 4; i <= w; i++) {
                stars[h][i] = '*';
            }
            return;
        }
        compute(h, w, idx / 2);
        compute(h, w - idx, idx / 2);
        compute(h - (idx / 2), w - (idx / 2), idx / 2);
    }

    public static void main(String[] args) throws IOException {
        BOJ2448.solution();
    }
}

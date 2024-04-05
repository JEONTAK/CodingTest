package BaekJoon.Gold5.별찍기10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {

    static int N;
    static char[][] stars;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        stars = new char[N][N];

        compute(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void compute(int x, int y ,int range, boolean blank){
        if(blank){
            for (int i = x; i < x + range; i++) {
                for (int j = y; j < y + range; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        if (range == 1) {
            stars[x][y] = '*';
            return;
        }

        int nr = range / 3;
        int count = 0;

        for (int i = x; i < x + range; i += nr) {
            for (int j = y; j < y + range; j += nr) {
                count++;
                if (count == 5) {
                    compute(i, j, nr, true);
                }
                else{
                    compute(i, j, nr, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2447.solution();
    }
}

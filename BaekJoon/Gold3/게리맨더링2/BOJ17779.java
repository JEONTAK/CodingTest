package BaekJoon.Gold3.게리맨더링2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {

    static int N;
    static int[][] map;
    static int total = 0;
    static int min = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if(x + d1 + d2 >= N) continue;
                        if(y - d1 < 0 || y + d2 >= N) continue;
                        compute(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(min);
    }

    static void compute(int x, int y, int d1, int d2) {
        boolean[][] zone = new boolean[N][N];
        for (int i = 0; i <= d1; i++) {
            zone[x + i][y - i] = true;
            zone[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            zone[x + i][y + i] = true;
            zone[x + d1 + i][y - d1 + i] = true;
        }

        int[] sum = new int[5];

        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if(zone[i][j])break;
                sum[0] += map[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if(zone[i][j]) break;
                sum[1] += map[i][j];
            }
        }

        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if(zone[i][j])break;
                sum[2] += map[i][j];
            }
        }

        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if(zone[i][j]) break;
                sum[3] += map[i][j];
            }
        }
        sum[4] = total;
        for (int i = 0; i < 4; i++) {
            sum[4] -= sum[i];
        }

        Arrays.sort(sum);
        min = Math.min(min, sum[4] - sum[0]);
    }

    public static void main(String[] args) throws IOException {
        BOJ17779.solution();
    }
}

package BaekJoon.Gold3.사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {

    static int N, M, H;
    static int[][] ladder;
    static int result = -1;
    static boolean flag = false;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x][y] = 1;
            ladder[x][y + 1] = -1;
        }
        for (int i = 0; i <= 3; i++) {
            result = i;
            compute(1, 0);
            if(flag) break;
        }
        if (flag) {
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }

    static void compute(int x, int cnt) {
        if(flag) return;

        if (result == cnt) {
            if (isAvailable()) flag = true;
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = -1;
                    compute(i, cnt + 1);
                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }
    }

    static boolean isAvailable() {
        for (int i = 1; i <= N; i++) {
            int x = i;
            for (int j = 1; j <= H; j++) {
                x = x + ladder[j][x];
            }
            if (x != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ15684.solution();
    }
}

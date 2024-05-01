package BaekJoon.Gold5.배열돌리기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16927 {

    static int N, M, R;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        compute();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void compute(){
        min = Math.min(N, M) / 2;
        for (int i = 0; i < min; i++) {
            int cnt = R % (((N - 2 * i) + (M - 2 * i)) * 2 - 4);
            rotate(i,cnt);
        }
    }

    static void rotate(int idx, int cnt){
        for (int r = 0; r < cnt; r++) {
            int x = idx;
            int y = idx;
            int temp = arr[y][x];

            int dir = 0;
            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (isNot(nx, ny, idx)) {
                    dir++;
                    continue;
                }

                arr[y][x] = arr[ny][nx];
                y = ny;
                x = nx;
            }
            arr[idx + 1][idx] = temp;
        }
    }

    static boolean isNot(int x, int y, int idx) {
        if (x < idx || y < idx || x >= M - idx || y >= N - idx) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ16927.solution();
    }
}

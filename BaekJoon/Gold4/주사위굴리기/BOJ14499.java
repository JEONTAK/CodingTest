package BaekJoon.Gold4.주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int top, bottom, left, right, front, back;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        top = 1;
        bottom = 6;
        front = 5;
        back = 2;
        left = 4;
        right = 3;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cur = Integer.parseInt(st.nextToken());
            compute(cur);
        }
    }

    static void compute(int cur){
        int nx = x + dx[cur];
        int ny = y + dy[cur];
        if (isAvailable(nx, ny)) {
            x = nx;
            y = ny;
            if (cur == 1) {
                int temp = bottom;
                bottom = right;
                right = top;
                top = left;
                left = temp;
            } else if (cur == 2) {
                int temp = bottom;
                bottom = left;
                left = top;
                top = right;
                right = temp;
            } else if (cur == 3) {
                int temp = bottom;
                bottom = back;
                back = top;
                top = front;
                front = temp;
            } else if (cur == 4) {
                int temp = bottom;
                bottom = front;
                front = top;
                top = back;
                back = temp;
            }
            if (map[x][y] == 0) {
                map[x][y] = dice[bottom];
            } else{
                dice[bottom] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[top]);
        }

    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ14499.solution();
    }
}

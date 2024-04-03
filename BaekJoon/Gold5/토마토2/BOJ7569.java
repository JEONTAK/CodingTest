package BaekJoon.Gold5.토마토2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

    static class Tomato{
        int z;
        int x;
        int y;
        int day;

        public Tomato(int z, int y, int x, int day) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    static int M, N, H;
    static int[][][] farm;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        farm = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    farm[i][j][k] = Integer.parseInt(st.nextToken());
                    if (farm[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k, 0));
                    }
                }
            }
        }

        compute();
    }

    static void compute(){
        int day = 0;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            day = tomato.day;
            for (int i = 0; i < 6; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];
                if (isAvailable(nx, ny, nz)) {
                    if (farm[nz][ny][nx] == 0) {
                        farm[nz][ny][nx] = 1;
                        queue.add(new Tomato(nz, ny, nx, day + 1));
                    }
                }
            }
        }

        if (allGrown()) {
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }

    static boolean allGrown(){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (farm[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    static boolean isAvailable(int nx, int ny, int nz) {
        return nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H;
    }

    public static void main(String[] args) throws IOException {
        BOJ7569.solution();
    }
}
